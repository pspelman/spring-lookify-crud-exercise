package com.philspelman.lookify.javaspringlookifyexercise.services;

import com.philspelman.lookify.javaspringlookifyexercise.models.Song;
import com.philspelman.lookify.javaspringlookifyexercise.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    //Done: initialize the song repository
    private SongRepository songRepository;

    //Done: define the public SongService, whose only attribute is the songRepository
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
        if (songRepository.findAll().size() < 1) {
            System.out.println("Nothing in the repo...adding some sample songs");
            this.addNewSongs();
        }
//        songRepository.deleteAll();

    }

    //ONE-TIME ADD NEW SONGS TO DB
    public void addNewSongs() {
        this.songRepository.save(new Song("SongTitle One", "Phil", 8));
        this.songRepository.save(new Song("SongTitle TWO", "Steve", 2));
        this.songRepository.save(new Song("Bigger is better", "America", 5));
    }

    //todo: add the CRUD methods to the service
    //getAll
    public List<Song> allSongs() {
        return songRepository.findAll();
    }

    public void addSong(Song song) {
        System.out.println("attempting to save the new song");
        songRepository.save(song);
    }

    //getById


    //editById

    //delete


}
