package com.amritbabu.busticketcounter.dao;

import com.amritbabu.busticketcounter.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus,String> {
}
