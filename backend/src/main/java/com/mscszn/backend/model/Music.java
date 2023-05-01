package com.mscszn.backend.model;

import java.io.InputStream;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "music")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Music {
    
    public Music(String musicName, String artistName, String genre, String trackLength, byte[] data, String filename){
        this.musicName = musicName;
        this.artistName = artistName;
        this.genre = genre;
        this.trackLength = trackLength;
        this.data = data;
        this.filename = filename;
    }

    @Id
    // use GenerationType.IDENTITY so that Hibernate stops looking for sequence table which keeps track of the next number to assign to the primary key
    // if use GenerationType.AUTO, Hibernate will look for the sequence table and if the sequence table is missing will have error
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int musicId;

    private String musicName;

    private String artistName;

    private String genre;

    private String trackLength;

     /* @Lob --> refers to a variable length datatype for storing large objects
       The datatype has 2 variants:
       CLOB – Character Large Object will store large text data
       BLOB – Binary Large Object is for storing binary data like image, audio, or video (using this) 
    */ 
    @Lob
    private byte[] data;

    private String filename;
}
