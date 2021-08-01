package com.alk.core.security.controller;

import com.alk.core.dto.Message;
import com.alk.core.security.dto.JwtDto;
import com.alk.core.security.dto.LoginUser;
import com.alk.core.security.dto.NewUser;
import com.alk.core.security.entity.Rol;
import com.alk.core.security.entity.User;
import com.alk.core.security.enums.RolName;
import com.alk.core.security.jwt.JwtProvider;
import com.alk.core.security.service.RolService;
import com.alk.core.security.service.UserService;
import com.alk.core.util.SendGreetingEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;
    
    @Autowired
    SendGreetingEmail sendGreetingEmail;

    @PostMapping("/register")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<Message>(new Message("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByUsername(newUser.getUsername())) {
            return new ResponseEntity<Message>(new Message("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByEmail(newUser.getEmail())) {
            return new ResponseEntity<Message>(new Message("ese email ya existe"), HttpStatus.BAD_REQUEST);
        }
        User user =
                new User(newUser.getName(), newUser.getUsername(), newUser.getEmail(),
                        passwordEncoder.encode(newUser.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolname(RolName.ROLE_USER).get());
        if(newUser.getRoles().contains("admin"))
            roles.add(rolService.getByRolname(RolName.ROLE_ADMIN).get());
        user.setRoles(roles);
        userService.save(user);
        sendGreetingEmail.sendEmail(newUser).getStatusCode();
        return new ResponseEntity<Message>(new Message("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginUser userLogin, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<Message>(new Message("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<JwtDto>(jwtDto, HttpStatus.OK);
    }
}
