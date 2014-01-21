package com.traveldoo.subject;

import com.traveldoo.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by arnaud on 19/01/2014.
 */

@Entity
@Table (name = "subject")

public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date creationDate;
    private String title;
    @ManyToOne
    @JoinColumn(name="id")
    private User author;

    public Subject() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


}
