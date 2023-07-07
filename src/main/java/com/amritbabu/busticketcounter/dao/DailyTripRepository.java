package com.amritbabu.busticketcounter.dao;

import com.amritbabu.busticketcounter.entities.DailyTrip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DailyTripRepository extends JpaRepository<DailyTrip, UUID> {

}
