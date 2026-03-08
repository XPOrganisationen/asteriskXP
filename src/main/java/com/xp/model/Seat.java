package com.xp.model;

import jakarta.persistence.*;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"theater", "rownumber", "seatnumber"}))
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;


    private Integer rowNumber;
    private Integer seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    public Seat() {}

    public Seat(Long theaterId, Integer rowNumber, Integer seatNumber, SeatType seatType) {

    }
}
