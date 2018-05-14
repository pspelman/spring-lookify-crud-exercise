package com.philspelman.lookify.javaspringlookifyexercise.repositories;

import com.philspelman.lookify.javaspringlookifyexercise.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    List<Song> findAll();


    //todo: Add some special searching methods to the repository that are interpreted by the DB request handler
    //search for songs by ARTIST NAME
//    List<Song> findByArtistContaining(String search);

    List<Song> findSongsByArtist(String search);

    //SEE TOP TEN SONGS (by rating)
    List<Song> findDistinctTopByRating(Long search);



}