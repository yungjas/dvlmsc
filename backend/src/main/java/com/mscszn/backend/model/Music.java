package com.mscszn.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "music")
public class Music {
    @Id
    private String musicId;

    private String musicName;

    private String artistName;

    private String genre;

    private String trackLength;
}
