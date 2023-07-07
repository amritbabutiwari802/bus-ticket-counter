package com.amritbabu.busticketcounter.dao;

import com.amritbabu.busticketcounter.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}
