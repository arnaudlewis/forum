package com.traveldoo.message.dto;

import com.traveldoo.subject.Subject;
import org.apache.james.mime4j.field.datetime.DateTime;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by arnaud on 10/02/2014.
 */

@Consumes(MediaType.APPLICATION_JSON)
@XmlType(name = "MessageCreateRequestDTO")
public class MessageCreateRequestDTO {

    @XmlElement(name="subject")
    private Subject subject;
    @XmlElement(name="title")
    private String title;
    @XmlElement(name="content")
    private String content;
    @XmlElement(name="creationDate")
    private Date creationDate;
    @XmlElement(name="author")
    private int id_author;

    public MessageCreateRequestDTO() {}


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
