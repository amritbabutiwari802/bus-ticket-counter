package com.amritbabu.busticketcounter.dao;

import com.amritbabu.busticketcounter.entities.BusStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BusStationRepository extends JpaRepository<BusStation, UUID> {
}
