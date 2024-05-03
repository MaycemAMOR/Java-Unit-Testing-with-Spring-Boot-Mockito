package com.maytech.unittesting.unittesting.controller;

import com.maytech.unittesting.unittesting.business.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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


    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item savedItem = businessService.createItem(item);
        // envoyer location aprés la création de chaque item
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedItem.getId())
                .toUri();
        return ResponseEntity.created(location).build(); /* amiliorer le code status de retour sucess response => 200
                                                            created status => 201
                                                            no content => 204
                                                            unauthorized (when authorization fails) => 401
                                                            Bad Request (validation error) => 400
                                                            resourcer is not found => 404
                                                            server exception => 500*/
    }

    @GetMapping("/items")
    public List<Item> retrieveAllItems() {
        return businessService.retrieveAllItem();
    }

    @GetMapping("/items/{id}")
    public Optional<Item> retrieveItemById(@PathVariable Integer id) {
        return businessService.retrieveItemById(id);
    }

}
