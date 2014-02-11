package com.traveldoo.message.dto;

import com.traveldoo.subject.Subject;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by arnaud on 10/02/2014.
 */

@XmlType(name = "MessageCreateResponseDTO")
@Produces(MediaType.APPLICATION_JSON)
public class MessageCreateResponseDTO {

    private int id_message;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    private Subject subject;

    public MessageCreateResponseDTO() {
    }

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }
}
