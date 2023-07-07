package com.amritbabu.busticketcounter.dao;

import com.amritbabu.busticketcounter.entities.BusReservationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusReservationHistoryRepository extends JpaRepository<BusReservationHistory, UUID> {
}
