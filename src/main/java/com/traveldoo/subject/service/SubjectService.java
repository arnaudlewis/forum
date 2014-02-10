package com.traveldoo.subject.service;

import com.traveldoo.subject.Subject;
import com.traveldoo.subject.dataAccess.DaoSubject;
import com.traveldoo.subject.dto.CreateSubjectRequestDTO;
import com.traveldoo.subject.dto.CreateSubjectResponseDTO;
import com.traveldoo.subject.dto.SubjectResponseDTO;
import com.traveldoo.user.dataAccess.DaoUser;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by arnaud on 27/01/2014.
 */

@Path("/subject")
public class SubjectService {

    @GET
    @Path("/list")
    public SubjectResponseDTO listAll() {
        SubjectResponseDTO response = new SubjectResponseDTO();
        List<Subject> liste = DaoSubject.getInstance().findAll();

        response.setListSubject(liste);

        return response;
    }

    @POST
    @Path("/create")
    public CreateSubjectResponseDTO create(CreateSubjectRequestDTO request) {
        CreateSubjectResponseDTO response = new CreateSubjectResponseDTO();
        Subject newSubject = new Subject();
        newSubject.setAuthor(DaoUser.getInstance().find(request.getId_author()));
        newSubject.setCreation_date(request.getCreationDate());
        newSubject.setTitle(request.getTitle());
        newSubject.setResolved(false);
        response.setId_subject(DaoSubject.getInstance().insert(newSubject));
        return response;
    }
}
