package com.amritbabu.busticketcounter.controllers;


import com.amritbabu.busticketcounter.dto.CreateTicketDto;
import com.amritbabu.busticketcounter.entities.Ticket;
import com.amritbabu.busticketcounter.services.TicketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/create")
    public Ticket create(@RequestBody()CreateTicketDto dto){
        return this.ticketService.create(dto);
    }


}
