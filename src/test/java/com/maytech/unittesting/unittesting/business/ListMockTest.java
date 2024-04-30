package com.maytech.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {

    List list = mock(List.class);

    @Test
    void size_basic() {
        when(list.size()).thenReturn(5);
        assertEquals(5, list.size());
    }

    @Test
    void returnDifferentValues() {
        when(list.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, list.size());
        assertEquals(10, list.size());
    }

    @Test
    void returnWithParameters() {
        when(list.get(0)).thenReturn("MayTech").thenReturn(10);
        assertEquals("MayTech", list.get(0));
        assertNull(list.get(1));
    }
}
