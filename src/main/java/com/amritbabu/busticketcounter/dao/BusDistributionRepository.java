package com.amritbabu.busticketcounter.dao;

import com.amritbabu.busticketcounter.entities.BusDistribution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BusDistributionRepository extends JpaRepository<BusDistribution, Integer> {

    public List<BusDistribution> findByBusNumberAndTripId(String busNumber, UUID tripId);
    public List<BusDistribution> findByTripId(UUID tripId);
}
