package com.mscszn.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mscszn.backend.model.Music;

@Repository
public interface MusicRepository extends MongoRepository<Music, String>{
    
}
