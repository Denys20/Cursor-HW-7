package com.example.Rest.service;

import com.example.Rest.model.Shop;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ShopService {
    private HashMap<String, Shop> db = new HashMap<>();

    public Shop addShop(Shop shop) {
        return db.put(shop.getId(), shop);
    }

    public Shop deleteById(String id) {
        return db.remove(id);
    }

    public List<Shop> getAllShop() {
        return new ArrayList<>(db.values());
    }

    public Shop getShopById(String id) {
        return db.get(id);
    }

    public Shop updateShopById(String id, Shop shop) {
        return db.put(id, shop);
    }
}
