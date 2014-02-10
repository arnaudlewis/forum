package com.traveldoo.user.dto;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by arnaud on 27/01/2014.
 */

@XmlType(name = "CreateUserResponseDTO")
@Produces(MediaType.APPLICATION_JSON)
public class CreateUserResponseDTO {

    private int id_user;

    public CreateUserResponseDTO() {}

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
