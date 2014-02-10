package com.traveldoo.user.service;

import com.traveldoo.user.User;
import com.traveldoo.user.dataAccess.DaoUser;
import com.traveldoo.user.dto.CreateUserRequestDTO;
import com.traveldoo.user.dto.CreateUserResponseDTO;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by arnaud on 27/01/2014.
 */

@Path("/user")
public class UserService {

    @POST
    @Path("/create")
    public CreateUserResponseDTO create(CreateUserRequestDTO request) {
        CreateUserResponseDTO response = new CreateUserResponseDTO();
        User newUser = new User();

        newUser.setAdmin(false);
        newUser.setInscription(request.getCreationDate());
        newUser.setEmail(request.getEmail());
        newUser.setFirstname(request.getFirstname());
        newUser.setLastname(request.getLastname());
        newUser.setUsername(request.getUsername());
        newUser.setPassword(request.getPassword());
        newUser.setAge(request.getAge());

        response.setId_user(DaoUser.getInstance().insert(newUser));
        return response;
    }
}
