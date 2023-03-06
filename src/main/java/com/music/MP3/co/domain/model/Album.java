package com.music.MP3.co.domain.model;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sys_album")
@Data
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "album_art_url")
    private String albumArtUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    private Artist artist;

//    @Cache(region = "artistCache", usage = CacheConcurrencyStrategy.READ_WRITE)
//    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Song> songs = new ArrayList<>();
}
