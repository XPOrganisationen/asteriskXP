package com.xp.Repository;

import com.xp.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository <Movie, Long> {
    Optional<Movie> findByMovieTitleContainingIgnoreCase(String movieTitle);
    @Query("""
            SELECT m AS movie
            FROM Movie m
            LEFT JOIN Show s ON s.movie = m
            LEFT JOIN Reservation r ON r.show = s
            LEFT JOIN r.movieTickets mt
            GROUP BY m
            ORDER BY COALESCE(COUNT(mt), 0) DESC
            """) // Whew.
    List<Movie> findAllByOrderByPopularityDesc(); // Popularity = Tickets sold
}
