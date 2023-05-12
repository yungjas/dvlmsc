package com.mscszn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mscszn.backend.model.Music;

@Repository
public interface MusicRepository extends CrudRepository<Music, Integer>{
    
    @Query(value="SELECT * FROM music m WHERE m.genre = ?1", nativeQuery = true)
    List<Music> findMusicByGenre(String genre);
}
