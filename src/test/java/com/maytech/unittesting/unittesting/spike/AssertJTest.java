package com.maytech.unittesting.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class AssertJTest {

    @Test
    void learning() {
        List<Integer> numbers = Arrays.asList(12, 15, 45);

//        assertThat(numbers, hasSize(3));
//        assertThat(numbers, hasItems(12, 15, 45));
//        assertThat(numbers, everyItem(greaterThan(10)));
//        assertThat(numbers, everyItem(lessThan(100)));

        assertThat(numbers).hasSize(3)
                .contains(12, 15)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100)
                .noneMatch(x -> x < 0);

//        assertThat("", emptyString());
//        assertThat("ABCDE", containsString("BCD"));
//        assertThat("ABCDE", endsWith("CDE"));

        assertThat("").isEmpty();
        assertThat("ABCDE").contains("BCD")
                .endsWith("CDE");
    }

}
