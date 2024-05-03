package com.maytech.unittesting.unittesting.controller;

import com.maytech.unittesting.unittesting.business.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    void maycemItem_basic() throws Exception {
        // call Get "/amor-item"  application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/maycem-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
    }

    @Test
    void itemFromBusinessService_basic() throws Exception {

        when(itemBusinessService.retrieveHardCodedItem()).thenReturn(
                new Item(2, "Item2", 10, 100)
        );

        // call Get "/amor-item"  application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2, name:Item2, price:10}"))
                .andReturn();
    }

    @Test
    void retrieveAllItem_basic() throws Exception {

        when(itemBusinessService.retrieveAllItem()).thenReturn(
                Arrays.asList(new Item(2, "Item2", 10, 100),
                        new Item(3, "Item3", 30, 300))
        );

        // call Get "/all-items-from-database"  application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2, name:Item2, price:10},{id:3, name:Item3, price:30}]"))
                .andReturn();
    }

    @Test
    void createItem_basic() throws Exception {

        // Create a sample saved item returned by the business service
        Item savedItem = new Item(1, "Item0", 100, 100);

        // Define the behavior of the mock business service
        when(itemBusinessService.createItem(any(Item.class))).thenReturn(savedItem);

        // Mock the request to create an item
        // call post "/items"  application/json
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/items")
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"item0\",\"price\":100,\"quantity\":100}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(header()
                        .string("Location", containsString("/items/1")))
                .andReturn();

        // Verify that the business service's createItem method was called with any Item object
        verify(itemBusinessService).createItem(any(Item.class));
    }

}
