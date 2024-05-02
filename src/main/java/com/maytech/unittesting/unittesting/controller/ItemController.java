package com.maytech.unittesting.unittesting.controller;

import com.maytech.unittesting.unittesting.business.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/maycem-item")
    Item maycemItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    Item itemFromBusinessService() {
        return itemBusinessService.retrieveHardCodedItem();
    }
}
