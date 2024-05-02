package com.maytech.unittesting.unittesting.controller;

import com.maytech.unittesting.unittesting.business.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/maycem-item")
    Item maycemItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    Item itemFromBusinessService() {
        return businessService.retrieveHardCodedItem();
    }

    @GetMapping("/all-items-from-database")
    List<Item> retrieveAllItem() {
        List<Item> items = businessService.retrieveAllItem();
        items.forEach(item -> item.setValue(item.getPrice() * item.getQuantity()));
        return items;
    }
}
