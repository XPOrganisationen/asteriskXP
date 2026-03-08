package com.xp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cinemaId;

    @Column(nullable = false, unique = true)
    private String cinemaName; // Remember that this becomes snake_case in the DB by default
    @Column(nullable = false)
    private String cinemaAddress;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // This does so we don't stack overflow (cinema-theater-cinema etc.)
    private List<Theater> theaters = new ArrayList<>();

    public Cinema() {}

    public Cinema(String cinemaName, String cinemaAddress)
    {
        this.cinemaName = cinemaName;
        this.cinemaAddress = cinemaAddress;
    }

    public Long getCinemaId()
    {
        return  cinemaId;
    }

    public String getCinemaAddress()
    {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress)
    {
        this.cinemaAddress = cinemaAddress;
    }

    public String getCinemaName()
    {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName)
    {
        this.cinemaName = cinemaName;
    }

    public void addTheater(Theater theater)
    {
        theaters.add(theater);
        theater.setCinema(null);
    }
}
