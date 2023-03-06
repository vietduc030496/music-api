package com.music.MP3.co.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sys_song")
@Data
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "link")
    private String link;

    @ManyToOne(fetch = FetchType.EAGER)
    private Artist artist;

    @ManyToOne(fetch = FetchType.EAGER)
    private Album album;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "SONG_GENRE",
            joinColumns = @JoinColumn(name = "SONG_ID"),
            inverseJoinColumns = @JoinColumn(name = "GENRE_ID"))
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany(mappedBy = "likedSongs", fetch = FetchType.LAZY)
    private List<User> likedUsers = new ArrayList<>();

    @ManyToMany(mappedBy = "songs", fetch = FetchType.LAZY)
    private List<PlayList> playlists = new ArrayList<>();

    @OneToMany(mappedBy = "song", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
}
