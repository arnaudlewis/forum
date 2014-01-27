package com.traveldoo.user.dto;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.*;

/**
 * Created by arnaud on 19/01/2014.
 */

@Consumes(MediaType.APPLICATION_JSON)
@XmlType(name = "LoginRequestDTO")
public class LoginRequestDTO {

    private String username;
    private String password;

    public LoginRequestDTO() {
    }

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
