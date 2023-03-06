package com.music.MP3.co.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "sys_comment")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Song song;
}
