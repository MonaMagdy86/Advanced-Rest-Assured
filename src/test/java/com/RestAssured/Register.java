package com.RestAssured;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Register {
    public static final String baseUrl="https://reqres.in/api";
    @Test
    public void RegisterSuccessfully(){
        File body=new File("src\\test\\resources\\Register.json");
        given().baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(body)
                .when().post("/register")
                .then().log().all()
                .assertThat().statusCode(200);

    }
    @Test
    public void RegisterUnsuccessfully(){
        File body=new File("src\\test\\resources\\RegisterUnSuccess.json");
        given().baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(body)
                .when().post("/register")
                .then().log().all()
                .assertThat().statusCode(400);
    }
}
