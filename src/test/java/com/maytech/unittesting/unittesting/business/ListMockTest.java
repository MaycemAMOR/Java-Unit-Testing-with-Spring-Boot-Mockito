package com.maytech.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> list = mock(List.class);

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
        when(list.get(0)).thenReturn("MayTech");
        assertEquals("MayTech", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    void returnWithGenericParameters() {
        when(list.get(anyInt())).thenReturn("MayTech");
        assertEquals("MayTech", list.get(0));
        assertEquals("MayTech", list.get(1));
    }

    @Test
    void verificationBasics() {
        //SUT
        String value1 = list.get(0);
        String value2 = list.get(1);

        //Verify
        verify(list).get(0);
        verify(list, times(2)).get(anyInt());
        verify(list, atLeast(1)).get(anyInt());
        verify(list, atLeastOnce()).get(anyInt());
        verify(list, atMost(2)).get(anyInt());
        verify(list, never()).get(2);

    }

    @Test
    void argumentCapturing() {
        //SUT
        list.add("SomeString");

        //Verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(list).add(captor.capture());

        assertEquals("SomeString", captor.getValue());

    }

    @Test
    void multipleArgumentCapturing() {
        //SUT
        list.add("SomeString1");
        list.add("SomeString2");

        //Verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(list, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    void mocking() {
        ArrayList<String> arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.getFirst()); //null
        System.out.println(arrayListMock.size());//0
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size());//0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());//5
    }

    @Test
    void spying() {
        ArrayList<String> arrayListMock = spy(ArrayList.class);
        arrayListMock.add("Test");
        System.out.println(arrayListMock.getFirst()); //Test
        System.out.println(arrayListMock.size());//1
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size());//3

        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());//5

        arrayListMock.add("Test4");
        System.out.println(arrayListMock.size());//5

        verify(arrayListMock).add("Test4");
    }
}
