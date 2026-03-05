package com.xp.Controller;


import com.xp.Model.MovieTicket;
import com.xp.Service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Un-named")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<MovieTicket> getAllTickets() {
        return ticketService.findAllTickets();
    }

    @GetMapping("/{id}")
    public MovieTicket getTicketsById(@PathVariable Long id) {
        return ticketService.findMovieTicketById(id);
    }
}
