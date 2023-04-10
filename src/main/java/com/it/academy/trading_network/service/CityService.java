package com.it.academy.trading_network.service;

import com.it.academy.trading_network.DTO.CityDTO;
import com.it.academy.trading_network.Entity.City;
import com.it.academy.trading_network.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    CityRepository cityRepository;

    public CityDTO getById(Long id) {
        City city = cityRepository.findById(id).orElse(new City());
        return mapToDTO(city);
    }

    public List<CityDTO> getAll() {
        List<City> cityList = cityRepository.findAll();
        List<CityDTO> cityDTOS = new ArrayList<>();
        for (City city : cityList) {
            cityDTOS.add(mapToDTO(city));
        }
        return cityDTOS;
    }

    public Long saveNewCity(CityDTO cityDTO) {
        City city = new City(cityDTO.getId(),
                cityDTO.getName(),
                cityDTO.getStreets(),
                cityDTO.getShops());
        return cityRepository.save(city).getId();
    }

    public CityDTO update(CityDTO cityDTO) {
        City city = cityRepository.findById(cityDTO.getId()).orElse(new City());
        cityRepository.save(city);
        return mapToDTO(city);
    }

    public String delete(Long id) {
        cityRepository.deleteById(id);
        return "City deleted";

    }

    public CityDTO mapToDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setShops(city.getShops());
        cityDTO.setStreets(city.getStreets());
        return cityDTO;
    }

    public City getByName(String name) {
       return cityRepository.getByName(name);
    }
}
