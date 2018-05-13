package com.philspelman.lookify.javaspringlookifyexercise.controllers;

import com.philspelman.lookify.javaspringlookifyexercise.models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class MainController {
    @RequestMapping("/")
    public String goToIndex(Model model) {
        System.out.println("MainController: Reached goToIndex(/) ");
        model.addAttribute("message", "Welcome from the model object!");

        return "index";
    }

    @RequestMapping("/dashboard")
    public String goToDashboard(Model model) {
        System.out.println("Going to the dashboard");

        //todo: get all the songs and add them to the model

        return "dashboard";
    }


    @RequestMapping("/songs/topTen")
    public String getTopTenSongs() {
        System.out.println("MainController: request for top ten songs...fetching songs");


        return "topTen";
    }


    //DONE: need to add a Song model to this, to be filled in by the user in the ADD form
    @GetMapping("/songs/new")
    public String addSong(@ModelAttribute("song") Song song) {


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

            //TODO: integrate the songService.addSong(song) functionality

            return "redirect:/";
        }


    }


    //TODO: add @GetMapping("/songs/edit/{id}") for editing a specific song



    //TODO: add @PostMapping("/songs/edit/{id}") for editing a specific song (receiving the data)


    //TODO: add @RequestMapping("/songs/delete/{id}") for deleting a specific song



}
