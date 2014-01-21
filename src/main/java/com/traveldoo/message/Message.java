package com.traveldoo.message;

import com.traveldoo.user.User;

import javax.persistence.*;

/**
 * Created by arnaud on 19/01/2014.
 */

@Entity
@Table (name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name="id")
    private User author;
}
