package com.traveldoo.user.dto;

import com.traveldoo.user.User;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by arnaud on 19/01/2014.
 */

@XmlType(name = "LoginResponseDTO")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResponseDTO {

    private int connect;
    private User user;

    public LoginResponseDTO() {
    }

    public int getConnect() {
        return connect;
    }

    public void setConnect(int connect) {
        this.connect = connect;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
