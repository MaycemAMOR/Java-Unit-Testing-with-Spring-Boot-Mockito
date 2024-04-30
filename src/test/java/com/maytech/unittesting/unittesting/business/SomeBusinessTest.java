package com.maytech.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessTest {

    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int calculateSome = business.calculateSum(new int[]{1, 2, 3});
        System.out.println(calculateSome);
        int expectedResult = 6;
        assertEquals(expectedResult, calculateSome);
    }

    @Test
    public void calculateSum_emptyArray() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int calculateSome = business.calculateSum(new int[]{});
        System.out.println(calculateSome);
        int expectedResult = 0;
        assertEquals(expectedResult, calculateSome);
    }

    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int calculateSome = business.calculateSum(new int[]{5});
        System.out.println(calculateSome);
        int expectedResult = 5;
        assertEquals(expectedResult, calculateSome);
    }


}
