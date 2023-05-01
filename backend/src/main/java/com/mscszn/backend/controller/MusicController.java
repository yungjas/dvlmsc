package com.mscszn.backend.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.mscszn.backend.model.Music;
import com.mscszn.backend.service.MusicService;

@RestController
@CrossOrigin
@RequestMapping(path="api/music")
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping("all")
    public ResponseEntity<List<Music>> getAllMusic(){
        List<Music> allMusic = musicService.getAllMusic();
        if(allMusic.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allMusic, HttpStatus.OK);
    }

    @GetMapping("{musicId}")
    public ResponseEntity<Object> getMusic(@PathVariable int musicId){
        Music music = musicService.getMusic(musicId);
        if(music == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(music, HttpStatus.OK);
    }

    @PostMapping("add-music-file")
    public ResponseEntity<Object> addMusicWithFile(@RequestParam String musicName, @RequestParam String artistName, @RequestParam String genre, 
        @RequestParam String trackLength, @RequestParam("file") MultipartFile file){
        
        Music createdMusic = null;
        try{
            createdMusic = musicService.addMusicWithFile(musicName, artistName, genre, trackLength, file);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); 
        }
        return new ResponseEntity<>(createdMusic, HttpStatus.OK);
    }
}
