package com.maytech.unittesting.unittesting.business;

import com.maytech.unittesting.unittesting.controller.Item;
import com.maytech.unittesting.unittesting.data.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemBusinessService {

    @Autowired
    ItemRepository repository;

    public List<Item> retrieveAllItem() {
        return repository.findAll();
    }

    public Item retrieveHardCodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public Item createItem(Item item) {
        return repository.save(item);
    }

    public Optional<Item> retrieveItemById(Integer id) {
        return repository.findById(id);
    }

}
