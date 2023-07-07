package com.amritbabu.busticketcounter.dao;

import com.amritbabu.busticketcounter.entities.WeeklyTrip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WeeklyTripRepository extends JpaRepository<WeeklyTrip, UUID> {
}
