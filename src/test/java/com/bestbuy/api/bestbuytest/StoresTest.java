package com.bestbuy.api.bestbuytest;

import com.bestbuy.api.model.StoresPojo;
import com.bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresTest extends TestBase {

    @Test
    public void getAllStoresInfo() {
        Response response =
                given()
                        .when()
                        .get("/stores");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createNewStores() {
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("calculator");
        storesPojo.setType("string");
        storesPojo.setAddress("12");
        storesPojo.setAddress2("wembley");
        storesPojo.setCity("London");
        storesPojo.setState("abcd");
        storesPojo.setZip("string");
        storesPojo.setLat(0);
        storesPojo.setLng(0);
        storesPojo.setHours("string");
       
        Response response = given()
                .header("Content-Type", "application/json")
                .body(storesPojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void deleteStores() {
        Response response =
                given()
                        .when()
                        .delete("/19");
        response.then().statusCode(404);
        response.prettyPrint();

    }
    @Test
    public void  getStoresById(){
        Response response =
                given()
                        .basePath("/stores")
                        .pathParam("id", 18)
                        .when()
                        .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void updateStores(){
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("La Crosse");
        Response response = given()
                .basePath("/stores")
                .header("Content-Type","application/json")
                .body(storesPojo)
                .when()
                .patch("/16");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
