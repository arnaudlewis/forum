package com.traveldoo.subject;

import com.traveldoo.message.Message;
import com.traveldoo.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_subject;
    private Date creationDate;
    private String title;
    @ManyToOne
    @JoinColumn(name="id_user")
    private User author;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "author")
    private List<Message> messageList;
    private boolean resolved;

    public Subject() {}

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id) {
        this.id_subject = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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