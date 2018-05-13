package com.philspelman.lookify.javaspringlookifyexercise.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Song {

    //song has ID, title, artist, rating, createdAt, updatedAt
    //todo: title, min 5ch
    //todo: artist, min 5ch
    //todo rating, Number between 1-10
    // know when it was created in the db
    // know when it was updated in the db

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Size(min = 5, max = 200)
    private String title;

    @Column
    @Size(min = 3, max = 200)
    private String artist;

    //originally Rating will be set by the user in the form
    @Column
    @Min(1)
    @Max(10)
    private double rating;

    //DONE: createdAt and updatedAt
    @Column(updatable = false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;

    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }


    public Song() {
    }

    public Song(@Size(min = 5, max = 200) String title, @Size(min = 3, max = 200) String artist, @Min(1) @Max(10) double rating) {

        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.onCreate();
        this.onUpdate();
    }


    //DONE: getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    //override the toString so it prints the title by Artist
    @Override
    public String toString() {
        return String.format("%s by %s", title, artist);
    }


}
