package com.bestbuy.api.bestbuytest;

import com.bestbuy.api.model.CategoriesPojo;
import com.bestbuy.api.model.ServicesPojo;
import com.bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesTest extends TestBase {

    @Test
    public void getAllCategoriesInfo() {
        Response response =
                given()
                        .when()
                        .get("/categories");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createNewCategories() {
        CategoriesPojo categoriesPojo = new CategoriesPojo();

        categoriesPojo.setName("Speaker");
        categoriesPojo.setId("abcd");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post("/categories");
        response.then().statusCode(201);
        response.prettyPrint();


    }

    @Test
    public void deleteCategories() {
        Response response =
                given()
                        .when()
                        .delete("/9");
        response.then().statusCode(404);
        response.prettyPrint();

    }

    @Test
    public void getCategoriesById() {
        Response response =
                given()
                        .basePath("/categories")
                        .pathParam("id", "abcat0020001")
                        .when()
                        .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void updateCategories() {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Mobile Specialty Store");
        Response response = given()
                .basePath("/categories")
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .patch("/abcat0010000");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
