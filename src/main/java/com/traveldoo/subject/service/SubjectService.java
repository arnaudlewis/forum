package com.traveldoo.subject.service;

import com.traveldoo.subject.Subject;
import com.traveldoo.subject.dataAccess.DaoSubject;
import com.traveldoo.subject.dto.SubjectResponseDTO;

import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by arnaud on 27/01/2014.
 */

@Path("/subject")
public class SubjectService {

    @Path("/list")
    public SubjectResponseDTO listAll() {
        SubjectResponseDTO response = new SubjectResponseDTO();
        List<Subject> liste = DaoSubject.getInstance().findAll();

        response.setListSubject(liste);

        return response;
    }
}
