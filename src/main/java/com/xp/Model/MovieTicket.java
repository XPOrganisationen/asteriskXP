package com.xp.Model;

import jakarta.persistence.*;

@Entity
public class MovieTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieTicketId;

    private Double price;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "show_id")
    private Show show;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    public MovieTicket() {}

    public MovieTicket(Double price, Show show, Seat seat) {
        this.price = price;
        this.show = show;
        this.seat = seat;
    }

    public Integer getMovieTicketId() {
        return movieTicketId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
