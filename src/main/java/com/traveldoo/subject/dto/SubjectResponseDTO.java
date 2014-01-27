package com.traveldoo.subject.dto;

import com.traveldoo.subject.Subject;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by arnaud on 27/01/2014.
 */
@XmlType(name = "SubjectResponseDTO")
@Produces(MediaType.APPLICATION_JSON)
public class SubjectResponseDTO {

    private List<Subject> listSubject;

    public SubjectResponseDTO() {
    }


    public List<Subject> getListSubject() {
        return listSubject;
    }

    public void setListSubject(List<Subject> listSubject) {
        this.listSubject = listSubject;
    }
}
