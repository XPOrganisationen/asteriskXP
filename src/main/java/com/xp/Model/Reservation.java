package com.xp.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "show_id")
    private Show show;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id")
    private List<MovieTicket> movieTickets;
}
