package com.xp.Model;

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
    private SeatAvailability seatAvailability;

    public Seat() {}

    public Seat(Long theaterId, Integer rowNumber, Integer seatNumber, SeatAvailability seatAvailability) {

    }

    public SeatAvailability getSeatAvailability() {
        return seatAvailability;
    }

    public void setSeatAvailability(SeatAvailability seatAvailability) {
        this.seatAvailability = seatAvailability;
    }
}
