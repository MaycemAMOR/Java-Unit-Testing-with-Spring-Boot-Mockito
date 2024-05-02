package com.maytech.unittesting.unittesting.data;

import com.maytech.unittesting.unittesting.controller.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    void testFindAll() {
        List<Item> items = repository.findAll();
        assertEquals(3, items.size());
        assertEquals(10001, items.getFirst().getId());
    }
}
