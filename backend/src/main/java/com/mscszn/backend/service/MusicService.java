package com.mscszn.backend.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.mscszn.backend.model.Music;

@Component
public interface MusicService {
    List<Music> getAllMusic();

    List<Music> getMusicByGenre(String genre);
    
    Music getMusic(int musicId);

    Music addMusicWithFile(String musicName, String artistName, String genre, String trackLength, MultipartFile file) throws IOException;
}
