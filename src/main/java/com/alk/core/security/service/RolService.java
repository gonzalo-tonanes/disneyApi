package com.alk.core.security.service;

import com.alk.core.security.entity.Rol;
import com.alk.core.security.enums.RolName;
import com.alk.core.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolname(RolName rolName){
        return rolRepository.findByRolname(rolName);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
