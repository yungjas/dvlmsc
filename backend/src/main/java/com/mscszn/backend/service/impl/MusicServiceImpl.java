package com.mscszn.backend.service.impl;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
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

    public List<Music> getMusicByGenre(String genre){
        List<Music> musicList = musicRepo.findMusicByGenre(genre);
        if(musicList != null){
            return musicList;
        }
        return null;
    }

    public Music getMusic(int musicId){
        Optional<Music> musicData = musicRepo.findById(musicId);
        if(musicData.isPresent()){
            return musicData.get();
        }
        return null;
    }

    public Music addMusicWithFile(String musicName, String artistName, String genre, String trackLength, MultipartFile file) throws IOException{
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        Music music = new Music(musicName, artistName, genre, trackLength, file.getBytes(), filename);
        return musicRepo.save(music);
    }
}
