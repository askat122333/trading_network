package com.it.academy.trading_network.DTO;

import com.it.academy.trading_network.Entity.City;
import com.it.academy.trading_network.Entity.Shop;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StreetDTO {
    private Long id;
    private String name;
    private City city;
    private List<Shop> shops;
}
