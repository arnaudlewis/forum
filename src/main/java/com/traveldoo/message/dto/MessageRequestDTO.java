package com.traveldoo.message.dto;


import com.traveldoo.subject.Subject;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by arnaud on 27/01/2014.
 */
@XmlType(name = "MessageRequestDTO")
@Consumes(MediaType.APPLICATION_JSON)
public class MessageRequestDTO {
    @XmlElement(name="idSubject")
    private int id_subject;

    public MessageRequestDTO() {
    }


    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }
}
