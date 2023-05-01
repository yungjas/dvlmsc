package com.mscszn.backend.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mscszn.backend.model.Music;

@Component
public interface MusicService {
    List<Music> getAllMusic();
    
    Music getMusic(String musicId);

    //Music addMusic(Music music);
}
