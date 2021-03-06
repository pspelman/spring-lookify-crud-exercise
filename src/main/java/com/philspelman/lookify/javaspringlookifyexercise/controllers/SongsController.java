package com.philspelman.lookify.javaspringlookifyexercise.controllers;

import com.philspelman.lookify.javaspringlookifyexercise.models.Song;
import com.philspelman.lookify.javaspringlookifyexercise.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public String getTopTenSongs(Model model) {
        System.out.println("SongsController: request for top ten songs...fetching songs");

        List<Song> songs = songService.getTopTenSongs();
        iterateSongListResults(songs);

        model.addAttribute("songs", songs);
        //FIXME: need to look at sorting https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#collections-sorted-set


        return "topTen";
    }

    protected static void iterateSongListResults(List<Song> songs) {
        for (Object object : songs) {
            if(object instanceof Song) {
                Song song = (Song) object;
                System.out.println(song.toString());
            }
            if(object instanceof ObjectError) {
                ObjectError objectError = (ObjectError) object;
                System.out.println(objectError.getCode());
            }
        }
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

            return "redirect:/dashboard";
        }


    }

    //TODO: add @GetMapping("songs/search/artist?{artistNameString}")
    @RequestMapping("/songs/search/artist")
    public String getSongsByArtist(Model model,
                                   @RequestParam(value = "artistNameString") String artistNameString,
                                   RedirectAttributes redirectAttributes) {

        System.out.println("trying to get songs by artist: " + artistNameString);
        //fixme: change the request so it gets all songs by the inputted artist name
        List<Song> songs = songService.getSongsByArtist(artistNameString);

        if (songs.size() > 0) {
            iterateSongListResults(songs);
        }


        if (songs.size() == 0) {
            model.addAttribute("error", "No songs by that artist were available");
            redirectAttributes.addFlashAttribute("artist_search_error", "No songs by that artist");

            return "redirect:/dashboard";
        } else {
            model.addAttribute("songs", songs);
            return "artist_songs";

        }
//        return "dashboard";

    }






    @RequestMapping(value = "/books/id/getById/")
    public String findBookByIndex(@ModelAttribute("errors") String errors,
                                  @RequestParam("find_book_id") String findId,
                                  RedirectAttributes redirectAttributes) {

        System.out.println("got form post for book id: " + findId);
        String redirectRoute = String.format("/books/%s",findId);

        return "redirect:" + redirectRoute;

    }


    //DONE: add @GetMapping("/songs/view/{id}") for viewing a specific song
    @RequestMapping("/songs/view/{id}")
    public String viewSongDetails(@PathVariable Long id,
                                  Model model,
                                  RedirectAttributes redirectAttributes,
                                  @ModelAttribute("errors") String errors) {

        System.out.println("Trying to get song w/id: " + id);

        Optional<Song> optionalSong = Optional.ofNullable(songService.findgSongById(id));

        if (optionalSong.isPresent()) {
            System.out.println("found the song...adding to model");
            model.addAttribute("song", optionalSong.get());

            return "song_details";
        } else {
            System.out.println("that song doesn't exist");
            redirectAttributes.addFlashAttribute("search_errors", "no such song");
            return "redirect:/dashboard";
        }

    }


    //TODO: add @GetMapping("/songs/edit/{id}") for editing a specific song


    //TODO: add @PostMapping("/songs/edit/{id}") for editing a specific song (receiving the data)






    //TODO: add @RequestMapping("/songs/delete/{id}") for deleting a specific song
    @RequestMapping("/songs/delete/{id}")
    public String destroySong(@PathVariable Long id) {
        System.out.println("got request to delete song: " + id);

        songService.destroySong(id);

        return "redirect:/dashboard";
    }



}
