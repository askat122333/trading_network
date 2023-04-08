package com.it.academy.trading_network.DTO;

import com.it.academy.trading_network.Entity.City;
import com.it.academy.trading_network.Entity.Street;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class ShopDTO {
    private Long id;
    private String name;
    private City cityId;
    private Street streetId;
    private LocalTime openTime;
    private LocalTime closingTime;
}
