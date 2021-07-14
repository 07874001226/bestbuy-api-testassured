package com.bestbuy.api.bestbuytest;


import com.bestbuy.api.model.ProductPojo;
import com.bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class ProductTest extends TestBase {
    @Test
    public void getAllProductsInfo() {
        Response response =
                given()
                        .when()
                        .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createNewProduct() {

        ProductPojo productPojo = new ProductPojo();


        productPojo.setName("oppo");
        productPojo.setType("mobile");
        productPojo.setPrice(40.50);
        productPojo.setUpc("2182021");
        productPojo.setShipping(15.25);
        productPojo.setDescription("opp mobile");
        productPojo.setManufacturer("opp Store");
        productPojo.setModel("String");
        productPojo.setUrl("String");
        productPojo.setImage("String");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .post("/products");
        response.then().statusCode(201);
        response.prettyPrint();


    }

    @Test
    public void deleteProduct() {
        Response response =
                given()
                        .when()
                        .delete("/48530");
        response.then().statusCode(404);
        response.prettyPrint();

    }
   @Test
   public void  getProductById(){
       Response response =
               given()
                       .basePath("/products")
                       .pathParam("id", 127687)
                       .when()
                       .get("/{id}");
       response.then().statusCode(200);
       response.prettyPrint();

   }
@Test
    public void updateProduct(){
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Sony Laptop");
    Response response = given()
            .basePath("/products")
            .header("Content-Type","application/json")
            .body(productPojo)
            .when()
            .patch("/347146");
    response.then().statusCode(200);
    response.prettyPrint();
}

}





