package com.traveldoo.subject.dto;


import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by arnaud on 27/01/2014.
 */
@Consumes(MediaType.APPLICATION_JSON)
@XmlType(name = "CreateSubjectRequestDTO")
public class CreateSubjectRequestDTO {

    @XmlElement(name="title")
    private String title;
    @XmlElement(name = "id_author")
    private int id_author;
    @XmlElement(name = "creationDate")
    private Date creationDate;

    public CreateSubjectRequestDTO() {}


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
