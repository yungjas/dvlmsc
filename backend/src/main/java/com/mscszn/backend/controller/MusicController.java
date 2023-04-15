package com.mscszn.backend.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
