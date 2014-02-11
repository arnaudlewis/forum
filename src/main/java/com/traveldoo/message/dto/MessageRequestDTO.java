package com.traveldoo.message.dto;

import com.traveldoo.subject.Subject;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by arnaud on 11/02/2014.
 */
@Consumes(MediaType.APPLICATION_JSON)
@XmlType(name = "MessageRequestDTO")
public class MessageRequestDTO {

    @XmlElement(name = "subject")
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
