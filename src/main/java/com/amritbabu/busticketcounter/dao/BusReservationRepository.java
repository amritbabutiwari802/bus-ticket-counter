package com.amritbabu.busticketcounter.dao;

import com.amritbabu.busticketcounter.entities.BusReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface BusReservationRepository extends JpaRepository<BusReservation, UUID> {


    List<BusReservation> findByReservationDate(LocalDate reservationDate);
}
