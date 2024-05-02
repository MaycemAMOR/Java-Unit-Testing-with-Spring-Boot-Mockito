package com.maytech.unittesting.unittesting.business;

import com.maytech.unittesting.unittesting.controller.Item;
import com.maytech.unittesting.unittesting.data.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    ItemBusinessService business;

    @Mock
    ItemRepository repository;


    @Test
    public void retrieveAllItem_basic() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Item2", 10, 100),
                new Item(3, "Item3", 30, 300)));
        List<Item> items = business.retrieveAllItem();
        assertEquals(2, items.size());
        assertEquals(1000, items.get(0).getPrice() * items.get(0).getQuantity());
        assertEquals(9000, items.get(1).getPrice() * items.get(1).getQuantity());
    }

}
