package com.it.academy.trading_network.controller;

import com.it.academy.trading_network.DTO.CityDTO;
import com.it.academy.trading_network.Entity.City;
import com.it.academy.trading_network.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/city")
public class CityController {
    CityService cityService;
    @GetMapping("/{id}")
    public CityDTO getById(@PathVariable Long id) {
        return cityService.getById(id);
    }
    @GetMapping("/all")
    public List<CityDTO> getAll () {
        return cityService.getAll();
    }
    @PostMapping("/save")
    public Long saveNewCity(@RequestBody CityDTO cityDTO) {
        return cityService.saveNewCity(cityDTO);
    }
    @PutMapping("/update")
    public CityDTO update(@RequestBody CityDTO cityDTO) {
        return cityService.update(cityDTO);
    }
    @DeleteMapping("/delete")
    public String delete (@PathVariable Long id) {
        return cityService.delete(id);
    }
    @GetMapping("/getByName")
    public City getByName( @RequestParam String name){
        return cityService.getByName(name);
    }
}
