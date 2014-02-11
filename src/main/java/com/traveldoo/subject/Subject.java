package com.traveldoo.subject;

import com.traveldoo.message.Message;
import com.traveldoo.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "subject")

@Entity
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_subject;
    @Temporal(TemporalType.DATE)
    private Date creation_date;
    private String title;
    @ManyToOne
    @PrimaryKeyJoinColumn(name="id_user")
    private User author;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Message> messageList;
    private boolean resolved;

    public Subject() {}

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id) {
        this.id_subject = id;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creationDate) {
        this.creation_date = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}