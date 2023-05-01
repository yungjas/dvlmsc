package com.mscszn.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mscszn.backend.model.Music;

@Repository
public interface MusicRepository extends CrudRepository<Music, Integer>{
    
}
