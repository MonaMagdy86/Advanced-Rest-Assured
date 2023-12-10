package com.RestAssured;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Login {
    public static final String baseUrl="https://reqres.in/api";

    @Test
    public void LoginSuccessfully(){
        LoginPOJO body=new LoginPOJO("eve.holt@reqres.in","cityslicka");
        given().baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(body)
                .when().post("/login")
                .then().log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void LoginUnSuccessfully(){
        LoginPOJO body=new LoginPOJO("peter@klaven");
        given().baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(body)
                .when().post("/login")
                .then().log().all()
                .assertThat().statusCode(400);
    }

}
