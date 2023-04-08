package com.it.academy.trading_network.repository;

import com.it.academy.trading_network.DTO.CityDTO;
import com.it.academy.trading_network.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    City getByName(String name);
}
