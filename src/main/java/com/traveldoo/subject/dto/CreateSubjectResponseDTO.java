package com.traveldoo.subject.dto;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by arnaud on 27/01/2014.
 */
@Produces(MediaType.APPLICATION_JSON)
@XmlType(name = "CreateSubjectResponseDTO")
public class CreateSubjectResponseDTO {

    private int id_subject;

    public CreateSubjectResponseDTO() {
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }
}
