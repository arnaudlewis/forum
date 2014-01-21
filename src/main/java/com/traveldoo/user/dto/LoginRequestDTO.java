package com.traveldoo.user.dto;

import javax.ws.rs.Consumes;
import javax.xml.bind.annotation.*;

/**
 * Created by arnaud on 19/01/2014.
 */

@XmlType(name = "LoginRequestDTO")
public class LoginRequestDTO {

    private String username;
    private String password;

    public LoginRequestDTO() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
