package com.maytech.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);  // strict => true it is mean a strict check

    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);  // strict => true it is mean a strect check

    }

    @Test
    public void jsonAssert_StrictFalse_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id:1, name:Ball , price:10}"; // String expectedResponse ="{id:1, name:\"Ball 2\", price:10}" :  we need the escape caracters when we have a space in the strin like in this cas "Ball 2"
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);  // strict => true it is mean a strect check

    }
}
