package com.it.academy.trading_network.DTO;

import com.it.academy.trading_network.Entity.Shop;
import com.it.academy.trading_network.Entity.Street;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CityDTO {
    private Long id;
    private String name;
    private List<Street> streets;
    private List<Shop> shops;
}
