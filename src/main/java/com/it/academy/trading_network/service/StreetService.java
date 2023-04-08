package com.it.academy.trading_network.service;

import com.it.academy.trading_network.DTO.StreetDTO;
import com.it.academy.trading_network.Entity.Street;
import com.it.academy.trading_network.repository.StreetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class StreetService {
    StreetRepository streetRepository;

    public StreetDTO getById(Long id) {
        Street street = streetRepository.findById(id).orElse(new Street());
        return mapToDTO(street);
    }

    public List<StreetDTO> getAll() {
        List<Street> streets = streetRepository.findAll();
        List<StreetDTO> streetDTOS = new ArrayList<>();
        for (Street street : streets) {
            streetDTOS.add(mapToDTO(street));
        }
        return streetDTOS;
    }

    public Long saveNewStreet(StreetDTO streetDTO) {
        Street street = new Street(streetDTO.getId(),
                streetDTO.getName(),
                streetDTO.getCity(),
                streetDTO.getShops());
        return streetRepository.save(street).getId();
    }

    public StreetDTO update(StreetDTO streetDTO) {
        Street street = streetRepository.findById(streetDTO.getId()).orElse(new Street());
        streetRepository.save(street);
        return mapToDTO(street);
    }

    public String delete(Long id) {
        streetRepository.deleteById(id);
        return "Street deleted";

    }
    public List<StreetDTO> getAllByCity(Long id) {
        List<Street> streetList = streetRepository.findAllByCity(id);
        List<StreetDTO> streetDTOS = new ArrayList<>();
        for (Street street:streetList) {
            streetDTOS.add(mapToDTO(street));
        }
        return streetDTOS;
    }

    public StreetDTO mapToDTO(Street street) {
        StreetDTO streetDTO = new StreetDTO();
        streetDTO.setId(street.getId());
        streetDTO.setName(street.getName());
        streetDTO.setCity(street.getCity());
        streetDTO.setShops(street.getShops());
        return streetDTO;
    }
}
