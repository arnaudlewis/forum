package com.traveldoo.message.dto;

import org.apache.james.mime4j.field.datetime.DateTime;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

/**
 * Created by arnaud on 10/02/2014.
 */
public class MessageCreateRequestDTO {

    @XmlElement(name="idSubject")
    private int idSubject;
    @XmlElement(name="title")
    private String title;
    @XmlElement(name="content")
    private String content;
    @XmlElement(name="creationDate")
    private Date creationDate;
    @XmlElement(name="author")
    private int id_author;

    public MessageCreateRequestDTO() {}

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

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
}
