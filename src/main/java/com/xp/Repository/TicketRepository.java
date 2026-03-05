package com.xp.Repository;

import com.xp.Model.MovieTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository <MovieTicket, Long> {
}
