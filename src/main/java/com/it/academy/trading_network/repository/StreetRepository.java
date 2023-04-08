package com.it.academy.trading_network.repository;

import com.it.academy.trading_network.DTO.StreetDTO;
import com.it.academy.trading_network.Entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street,Long> {
    List<Street> findAllByCity(Long id);
    Street getByName(String name);
}
