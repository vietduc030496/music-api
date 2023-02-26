package com.music.MP3.co.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "sys_user")
@Data
public class User extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
