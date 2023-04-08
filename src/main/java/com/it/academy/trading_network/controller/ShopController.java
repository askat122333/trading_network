package com.it.academy.trading_network.controller;

import com.it.academy.trading_network.DTO.ShopDTO;
import com.it.academy.trading_network.service.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/shop")
public class ShopController {
    ShopService shopService;
    @GetMapping("/{id}")
    public ShopDTO getById(@PathVariable Long id) {
        return shopService.getById(id);
    }
    @GetMapping("/all")
    public List<ShopDTO> getAll () {
        return shopService.getAll();
    }
    @GetMapping("/")
    public List<ShopDTO> getShops(
            @RequestParam(required = false) String street,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Integer open
    ) {
        return shopService.getFilteredShops(street,city,open);
    }

    @PostMapping("/save")
    public Long saveNewShop(@RequestBody ShopDTO shopDTO) {
        return shopService.saveNewShop(shopDTO);
    }
    @PutMapping("/update")
    public ShopDTO update(@RequestBody ShopDTO shopDTO) {
        return shopService.update(shopDTO);
    }
    @PutMapping("/shopRegistration")
    public ShopDTO registration(
            @RequestParam Long shopId,
            @RequestParam String street,
            @RequestParam String city
    ){
        return shopService.registration(shopId,street,city);
    }
    @DeleteMapping("/delete")
    public String delete (@PathVariable Long id) {
        return shopService.delete(id);
    }
}
