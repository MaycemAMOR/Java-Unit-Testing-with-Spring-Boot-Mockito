package com.maytech.unittesting.unittesting.business;

import com.maytech.unittesting.unittesting.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        System.out.println("Calculate Sum Of an Integer array ");

        /***** With Functional Programming *****/

        /*****  V1 With Reduce and lambda Functional Programming *****/
        //System.out.println("V1 With Reduce and lambda Functional Programming");
        //return Arrays.stream(data).reduce(0, (a,b) -> (a+b));

        /*****  V2 With Reduce and Method reference Functional Programming *****/
        System.out.println("V2 With Reduce and Method reference Functional Programming");
        System.out.println(Arrays.stream(data).reduce(0, Integer::sum));
        return Arrays.stream(data).reduce(0, Integer::sum);

        /*****  V3 With sum Functional Programming *****/
        //System.out.println("V3 With sum Functional Programming");
        //return Arrays.stream(data).sum();

        /***** With Structure Programming *****/
        //System.out.println("With Structure Programming");
        //int sumInt = 0;
        //
        //for (int dataValue : data) {
        //sumInt += dataValue;
        //}
        //return sumInt;
    }


    public int calculateSumUsingDataService() {
        System.out.println("Calculate Sum Of an Integer array ");
        int[] data = someDataService.retrieveAllData();
        /*****  V2 With Reduce and Method reference Functional Programming *****/
        System.out.println("V2 With Reduce and Method reference Functional Programming");
        System.out.println(Arrays.stream(data).reduce(0, Integer::sum));
        return Arrays.stream(data).reduce(0, Integer::sum);

    }
}
