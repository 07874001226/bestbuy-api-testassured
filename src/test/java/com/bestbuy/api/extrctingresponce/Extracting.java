package com.bestbuy.api.extrctingresponce;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Extracting {
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

    //1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of limit is: " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //2. Extract the total
    @Test
    public void test002() {

        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("he total number of total is: " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {

        String name = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product name is: " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the names of all the store
    @Test
    public void test004() {

        List<String> name = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product name is: " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {

        List<String> id = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product id is: " + id);
        System.out.println("------------------End of Test---------------------------");
    }

    //6. Print the size of the data list
    @Test
    public void test006() {

        int size = response.extract().path("data.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the size are: " + size);
        System.out.println("------------------End of Test---------------------------");
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<HashMap<String, ?>> value = response.extract().path("data.findAll{it.name=='St Cloud'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the value are: " + value);
        System.out.println("------------------End of Test---------------------------");
    }

    //8. Get the address of the store where store name = Minnetonka
    @Test
    public void test008() {
        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.name=='Minnetonka'}.address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the address are: " + address);
        System.out.println("------------------End of Test---------------------------");
    }

    //9. Get all the services of 8th store
    @Test
    public void test009() {

        List<HashMap<String, Object>> services = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the services are: " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //10. Get storeservices of the store where service name = Sony Experience
    @Test
    public void test0010() {

        List<HashMap<String, Object>> services = response.extract().path("data.services[9].storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the services are: " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void test0011() {

        List<HashMap<String, Object>> storeid = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product store id is: " + storeid);
        System.out.println("------------------End of Test---------------------------");
    }

    //12. Get id of all the store
    @Test
    public void test0012() {
        List<HashMap<String, Object>> id = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product id is: " + id);
        System.out.println("------------------End of Test---------------------------");
    }

    //13. Find the store names Where state = MN
    @Test
    public void test13() {
        List<String> name = response.extract().path("data.findAll{it.state=='MN'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store name are: " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test14() {

        int services = response.extract().path("data[7].services.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the services are: " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test15() {

        List<HashMap<String, Object>> createdAt = response.extract().path("data.services[7].createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the createdAt are: " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    // 16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test16() {
        List<HashMap<String, ?>> services = response.extract().path("data.findAll{it.name=='Minnetonka'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the services are: " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //            17. Find the zip of all the store
    @Test
    public void test17() {

        List<HashMap<String, Object>> zip = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the zip are: " + zip);
        System.out.println("------------------End of Test---------------------------");
    }


    //18. Find the zip of store name = Rochester
    @Test
    public void test18() {

        List<Integer> zip = response.extract().path("data.findAll{it.name=='Rochester'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the zip are: " + zip);
        System.out.println("------------------End of Test---------------------------");
    }

    //19. Find the storeservices details of the service name = Samsung Experience
    @Test
    public void test19() {
        List<HashMap<String, ?>> services = response.extract().path("data.findAll{it.name=='Samsung Experience'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the services are: " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //20. Find the lat of all the stores
    @Test
    public void test20() {
        List<HashMap<String, Object>> lat = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the lat are: " + lat);
        System.out.println("------------------End of Test---------------------------");
    }
}
