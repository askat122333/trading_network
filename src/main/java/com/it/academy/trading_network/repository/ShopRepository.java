package com.it.academy.trading_network.repository;

import com.it.academy.trading_network.Entity.City;
import com.it.academy.trading_network.Entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Long> {
}
