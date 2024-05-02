package com.maytech.unittesting.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/maycem-item")
    Item maycemItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
