package com.it.academy.trading_network.service;

import com.it.academy.trading_network.DTO.ShopDTO;
import com.it.academy.trading_network.Entity.City;
import com.it.academy.trading_network.Entity.Shop;
import com.it.academy.trading_network.Entity.Street;
import com.it.academy.trading_network.repository.CityRepository;
import com.it.academy.trading_network.repository.ShopRepository;
import com.it.academy.trading_network.repository.StreetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShopService {
    ShopRepository shopRepository;
    CityRepository cityRepository;
    StreetRepository streetRepository;


    public ShopDTO getById(Long id) {
        Shop shop = shopRepository.findById(id).orElse(new Shop());
        return mapToDTO(shop);
    }

    public List<ShopDTO> getAll() {
        List<Shop> shopList = shopRepository.findAll();
        List<ShopDTO> shopDTOS = new ArrayList<>();
        for (Shop shop : shopList) {
            shopDTOS.add(mapToDTO(shop));
        }
        return shopDTOS;
    }

    public Long saveNewShop(ShopDTO shopDTO) {
        Shop shop = new Shop(shopDTO.getId(),
                shopDTO.getName(),
                shopDTO.getCityId(),
                shopDTO.getStreetId(),
                shopDTO.getOpenTime(),
                shopDTO.getClosingTime());
        return shopRepository.save(shop).getId();
    }

    public ShopDTO update(ShopDTO shopDTO) {
        Shop shop = shopRepository.findById(shopDTO.getId()).orElse(new Shop());
        if (shop.getId() != 0) shop.setId(shopDTO.getId());
        if (shop.getName()!= null) shop.setName(shopDTO.getName());
        if (shop.getCity() != null) shop.setCity(shopDTO.getCityId());
        if (shop.getStreet() != null) shop.setStreet(shopDTO.getStreetId());
        if (shop.getOpenTime() != null) shop.setOpenTime(shopDTO.getOpenTime());
        if (shop.getClosingTime() != null) shop.setClosingTime(shopDTO.getClosingTime());
        shopRepository.save(shop);
        return mapToDTO(shop);
    }

    public String delete(Long id) {
        shopRepository.deleteById(id);
        return "Shop deleted";

    }


    public ShopDTO mapToDTO(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setId(shop.getId());
        shopDTO.setName(shop.getName());
        shopDTO.setCityId(shop.getCity());
        shopDTO.setStreetId(shop.getStreet());
        shopDTO.setOpenTime(shop.getOpenTime());
        shopDTO.setClosingTime(shop.getClosingTime());
        return shopDTO;
    }

    public List<ShopDTO> getFilteredShops(String street, String city, Integer open) {
        List<Shop> shops = shopRepository.findAll();
        if (street != null) {
            Street street1 = streetRepository.getByName(street);
            shops = shops.stream()
                    .filter(shop -> shop.getStreet() == street1).toList();
        }
        if (city != null) {
            City city1 = cityRepository.getByName(city);
            shops = shops.stream()
                    .filter(shop -> shop.getCity() == city1).toList();
        }
        if (open != null) {
            shops = shops.stream()
                    .filter(shop -> isOpen(shop, open)).toList();
        }
        List<ShopDTO> shopDTOS = new ArrayList<>();
        for (Shop shop : shops) {
            shopDTOS.add(mapToDTO(shop));
        }
        return shopDTOS;

    }
    private boolean isOpen(Shop shop, int open) {
        LocalTime currentTime = LocalTime.now();
        if (open == 0) {
            return currentTime.isBefore(shop.getOpenTime()) || currentTime.isAfter(shop.getClosingTime());
        } else {
            return !currentTime.isBefore(shop.getOpenTime()) && !currentTime.isAfter(shop.getClosingTime());
        }
    }

    public ShopDTO registration(Long shopId, String street, String city) {
        Shop shop = shopRepository.findById(shopId).orElse(new Shop());
        shop.setCity(cityRepository.getByName(city));
        shop.setStreet(streetRepository.getByName(street));
        return  mapToDTO(shopRepository.save(shop));
    }
}

