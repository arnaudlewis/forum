package com.traveldoo.user.service;

import com.traveldoo.user.User;
import com.traveldoo.user.dataAccess.DaoUser;
import com.traveldoo.user.dto.LoginRequestDTO;
import com.traveldoo.user.dto.LoginResponseDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;


/**
 * Created by arnaud on 19/01/2014.
 */

@Path ("/login")
public class LoginService {


    @POST
    @Path("/connect")
    public LoginResponseDTO authentication(LoginRequestDTO request) {

        LoginResponseDTO response = new LoginResponseDTO();
    User loggedUser = DaoUser.getInstance().authentication(request.getUsername(), request.getPassword());
        if(loggedUser != null) {
            response.setConnect(1);
        } else {
            response.setConnect(0);
        }

        response.setUser(loggedUser);

        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/test")
    public String helloResource() {
        return "Hello! It's "+new Date();
    }

}
