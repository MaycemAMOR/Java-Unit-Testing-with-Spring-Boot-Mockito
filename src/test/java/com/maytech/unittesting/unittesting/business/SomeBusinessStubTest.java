package com.maytech.unittesting.unittesting.business;

import com.maytech.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{1, 2, 3};
    }
}

class SomeDataServiceStub1 implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceStub2 implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{5};
    }
}

public class SomeBusinessStubTest {

    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int calculateSome = business.calculateSumUsingDataService();
        System.out.println(calculateSome);
        int expectedResult = 6;
        assertEquals(expectedResult, calculateSome);
    }

    @Test
    public void calculateSum_emptyArray() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub1());
        int calculateSome = business.calculateSumUsingDataService();
        System.out.println(calculateSome);
        int expectedResult = 0;
        assertEquals(expectedResult, calculateSome);
    }

    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub2());
        int calculateSome = business.calculateSumUsingDataService();
        System.out.println(calculateSome);
        int expectedResult = 5;
        assertEquals(expectedResult, calculateSome);
    }


}
