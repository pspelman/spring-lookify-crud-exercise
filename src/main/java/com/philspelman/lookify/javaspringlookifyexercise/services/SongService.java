package com.philspelman.lookify.javaspringlookifyexercise.services;

import com.philspelman.lookify.javaspringlookifyexercise.models.Song;
import com.philspelman.lookify.javaspringlookifyexercise.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //create new song
    public void addSong(Song song) {
        System.out.println("attempting to save the new song");
        songRepository.save(song);
    }

    //search by artist name string
    public List<Song> getSongsByArtist(String artistNameString) {
        System.out.println("trying to get all songs by: " + artistNameString);

        List<Song> songs = songRepository.findSongsByArtist(artistNameString);

        if (songs.size() > 0) {
            System.out.printf("songs by %s were found!%n", artistNameString);
            return songs;
        } else {
            System.out.println("No songs found by that artist");
            return null;
        }
    }

    //get top10 in order
    public List<Song> getTopTenSongs() {
        System.out.println("Trying to get top 10 songs");
//        List<Song> topTenSongs = songRepository.findTopByRating();
        //FIXME: need to look at sorting https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#collections-sorted-set

        return allSongs();

    }


    //getById
    public Song findgSongById(Long id) {
        System.out.println("trying to get song by id: " + id);

        Optional<Song> optionalSong = songRepository.findById(id);
        if (optionalSong.isPresent()) {
            System.out.println("found song!");
            return optionalSong.get();
        } else {
            return null;
        }
    }


    //editById
    public void updateSong(Song song) {
        songRepository.save(song);
    }

    //delete
    public void destroySong(Long id) {
        System.out.println("SongService: Trying to destroy song");
        try {
            songRepository.deleteById(id);

        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());

        }

    }


}
