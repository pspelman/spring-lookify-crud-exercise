package com.philspelman.lookify.javaspringlookifyexercise.controllers;

import com.philspelman.lookify.javaspringlookifyexercise.models.Song;
import com.philspelman.lookify.javaspringlookifyexercise.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@Controller
public class SongsController {

    //done: Initialize the service(link to repository)
    private final SongService songService;
    public SongsController(SongService songService) {
        this.songService = songService;
    }


    @RequestMapping("/")
    public String goToIndex(Model model) {
        System.out.println("SongsController: Reached goToIndex(/) ");
        model.addAttribute("message", "Welcome from the model object!");
//        return "tagdex";
        return "index";
    }


    @RequestMapping("/dashboard")
    public String goToDashboard(Model model) {
        System.out.println("Going to the dashboard...get all the songs!");
        model.addAttribute("dashboard_message", "Hello in the nav thing");

        //todo: get all the songs and add them to the model
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);

        return "dashboard";
    }


    @RequestMapping("/songs/topTen")
    public String getTopTenSongs() {
        System.out.println("SongsController: request for top ten songs...fetching songs");


        return "topTen";
    }


    //DONE: need to add a Song model to this, to be filled in by the user in the ADD form
    @GetMapping("/songs/new")
    public String addSong(@ModelAttribute("song") Song song) {
        System.out.println("getting the new song form");

        return "songFormNew";
    }

    @PostMapping("/songs/new")
    public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult bindingResult) {
        System.out.println("got form data for a new song...checking");
        if (bindingResult.hasErrors()) {
            System.out.println("errors in form data");
            return "songFormNew";
        } else {
            System.out.println("no errors...trying to add the song!");
            System.out.printf("Received: %s by %s with a rating of %f%n", song.getTitle(), song.getArtist(), song.getRating());

            //TODO: integrate the songService.addSong(song) functionality

            songService.addSong(song);

            return "redirect:/";
        }


    }

    //TODO: add @GetMapping("songs/search/artist?{artistNameString}")
    @RequestMapping("/songs/search/artist{artistNameString}")
    public String getSongsByArtist(@PathVariable String artistNameString, Model model) {

        //fixme: change the request so it gets all songs by the inputted artist name
        List<Song> songs = songService.allSongs();

        model.addAttribute("artistSongs", songs);

        return "artist_songs";
    }


    //TODO: add @GetMapping("/songs/edit/{id}") for editing a specific song



    //TODO: add @PostMapping("/songs/edit/{id}") for editing a specific song (receiving the data)


    //TODO: add @RequestMapping("/songs/delete/{id}") for deleting a specific song



}
