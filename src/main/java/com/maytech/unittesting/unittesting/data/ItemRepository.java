package com.maytech.unittesting.unittesting.data;

import com.maytech.unittesting.unittesting.controller.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
