package com.it.academy.trading_network.controller;

import com.it.academy.trading_network.DTO.StreetDTO;
import com.it.academy.trading_network.service.StreetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/street")
public class StreetController {
    StreetService streetService;
    @GetMapping("/{id}")
    public StreetDTO getById(@PathVariable Long id) {
        return streetService.getById(id);
    }
    @GetMapping("/all")
    public List<StreetDTO> getAll () {
        return streetService.getAll();
    }
    @PostMapping("/save")
    public Long saveNewStreet(@RequestBody StreetDTO streetDTO) {
        return streetService.saveNewStreet(streetDTO);
    }
    @PutMapping("/update")
    public StreetDTO update(@RequestBody StreetDTO streetDTO) {
        return streetService.update(streetDTO);
    }
    @DeleteMapping("/delete")
    public String delete (@PathVariable Long id) {
        return streetService.delete(id);
    }
    @GetMapping("/all/by_city/{id}")
    public List<StreetDTO> getAllByCity (@PathVariable Long id) {
       return streetService.getAllByCity(id);
    }
}
