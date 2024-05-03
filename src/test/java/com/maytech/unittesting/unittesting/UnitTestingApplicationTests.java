package com.maytech.unittesting.unittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@TestPropertySource(locations = {"classpath:test-configuration.properties"})
// on peut spécifier une configuration lié au test en créant le fichier test-configuration.properties dans les ressources des tests
class UnitTestingApplicationTests {

    @Test
    void contextLoads() {
    }

}
