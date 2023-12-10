package com.RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Delay {
    public static final String baseUrl="https://reqres.in/api";
    @Test
    public void DelayedResponse(){
        given().baseUri(baseUrl)
                .when().get("/users?delay=3")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
