package com.mscszn.backend.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mscszn.backend.model.Music;
import com.mscszn.backend.repository.MusicRepository;
import com.mscszn.backend.service.MusicService;

@Service
public class MusicServiceImpl implements MusicService{
    
    @Autowired
    private MusicRepository musicRepo;

    public List<Music> getAllMusic(){
        return (List<Music>) musicRepo.findAll();
    }

    public Music getMusic(String musicId){
        Optional<Music> musicData = musicRepo.findById(musicId);
        if(musicData.isPresent()){
            return musicData.get();
        }
        return null;
    }

    // public Music addMusic(Music music, MultipartFile file){
    //     try{
    //         music.setStream(operations.getResource(file).getInputStream());
    //     }
    // }
}
