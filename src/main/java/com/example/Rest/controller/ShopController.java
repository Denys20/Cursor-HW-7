package com.example.Rest.controller;

import com.example.Rest.model.Shop;
import com.example.Rest.service.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {
    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        Shop createdShop = shopService.addShop(shop);
        return new ResponseEntity<>(createdShop, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Shop> deleteShop(@PathVariable String id) {
        Shop deleteShop = shopService.deleteById(id);
        if(deleteShop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(deleteShop, HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Shop>> getAllShop() {
        List<Shop> shopList = shopService.getAllShop();
        return  new ResponseEntity<>(shopList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable String id) {
        Shop shopById = shopService.getShopById(id);
        if(shopById == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(shopById, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShopById(@PathVariable String id, @RequestBody Shop shop) {
        Shop updateShop = shopService.updateShopById(id, shop);
        if(updateShop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updateShop, HttpStatus.OK);
        }
    }
}
