package com.traveldoo.message.dto;

import com.traveldoo.message.Message;
import com.traveldoo.subject.Subject;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by arnaud on 27/01/2014.
 */
@XmlType(name = "MessageResponseDTO")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResponseDTO {

    private Subject subject;

    public MessageResponseDTO() {
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
