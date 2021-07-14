package com.bestbuy.api.assertion;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.*;

public class Assertion {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then();

    }

    //1. Verify the if the total is equal to 1560
    @Test
    public void test001() {
        response.body("total", Matchers.equalTo(1560));
    }

    //2. Verify the if the stores of limit is equal to 10
    @Test
    public void test002() {
        response.body("limit", Matchers.equalTo(10));
    }

    //3. Check the single ‘Name’ in the Array list (Square83215)
    @Test
    public void test003() {
        response.body("data.name", hasItem("Inver Grove Heights"));

    }

    //4. Check the multiple ‘Names’ in the ArrayList (Square83215, Southridge, Green Bay)
    @Test
    public void test004() {
        response.body("data.name", hasItems("Burnsville", "s&v", "Fargo"));
    }

    //5. Verify the storied inside storeservices of the third store of second services
    @Test
    public void test005() {
        response.body("data[2].services[1]", hasKey("storeservices"));

    }

    //6. Check hash map values ‘createdAt’ inside storeservices map where store name = Southridge
    @Test
    public void test006() {
        response.body("data[2].services[1]", hasKey("createdAt"));
    }

    //7. Verify the state =  MN third store
    @Test
    public void test007() {
        response.body("data[2].state", equalTo("MN"));
    }

    //8. Verify the name = Green Bay of 9th store
    @Test
    public void test008() {
        response.body("data[8].name", equalTo("Rochester"));
    }

    //9. Verify the storeId = 23 for the 6th store
    @Test
    public void test009() {
        response.body("data[5].id", equalTo(11));
    }

    //10. Verify the serviceId = 14 for the 7th store
    @Test
    public void test10() {
        response.body("data[6].services[9].storeServices.serviceId", equalTo(15));
    }
}


