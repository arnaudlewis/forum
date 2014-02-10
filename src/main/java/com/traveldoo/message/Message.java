package com.traveldoo.message;

import com.traveldoo.subject.Subject;
import com.traveldoo.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by arnaud on 19/01/2014.
 */

@Table(name = "message")
@Entity
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_message;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id_user")
    private User author;
    private String content;
    private String title;
    @Temporal(TemporalType.DATE)
    private Date creation_date;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id_subject")
    private Subject subject;

    public Message() {
    }

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


}
