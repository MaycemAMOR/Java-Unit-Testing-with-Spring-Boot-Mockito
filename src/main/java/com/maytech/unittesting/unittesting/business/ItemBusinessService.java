package com.maytech.unittesting.unittesting.business;

import com.maytech.unittesting.unittesting.controller.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {

    public Item retrieveHardCodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

}
