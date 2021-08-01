package com.alk.core.security.dto;



import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

public class NewUser {
	@NotEmpty(message = "required field")
    private String name;
    @NotEmpty(message = "required field")
    private String username;
    @NotEmpty(message = "required field")
    private String email;
    @NotEmpty(message = "required field")
    private String password;
    private Set<String> roles = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
