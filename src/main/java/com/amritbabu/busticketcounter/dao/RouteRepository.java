package com.amritbabu.busticketcounter.dao;


import com.amritbabu.busticketcounter.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RouteRepository extends JpaRepository<Route, UUID> {


}
