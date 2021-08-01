package com.alk.core.security.dto;

import javax.validation.constraints.NotEmpty;



public class LoginUser {
	
	@NotEmpty(message = "required field")
    private String userName;
	@NotEmpty(message = "required field")
    private String password;

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
