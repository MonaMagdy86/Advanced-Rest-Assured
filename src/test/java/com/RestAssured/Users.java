package com.RestAssured;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;


public class Users {

  public static final   String baseUrl="https://reqres.in/api";

    @Test
    public void ListUsers(){

        given().baseUri(baseUrl)
                .header("first_name","George")
                .log().all()
        . when()
                .get("/users")
        .then()
                .log().all()
                .assertThat().statusCode(200);

    }
    @Test
    public void SingleUser(){
        given().baseUri(baseUrl)
                .when().get("/users/2")
                .then().log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void SingleUserNotFound(){
        given().baseUri(baseUrl)
                .when().get("/users/23")
                .then().log().all()
                .assertThat().statusCode(404);
    }
    @Test
    public void LISTRESOURCE(){
        given().baseUri(baseUrl)
                .when().get("/unknown")
                .then().log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void SingleRESOURCE(){
        given().baseUri(baseUrl)
                .when().get("/unknown/6")
                .then().log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void LISTRESOURCENOTFOUND(){
        given().baseUri(baseUrl)
                .when().get("/unknown/22")
                .then().log().all()
                .assertThat().statusCode(404);
    }
    @Test
    public void CreateUser(){
        File body=new File("src\\test\\resources\\CreateUser.json");
        given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(body)
                .when().post("/users/2")
                .then().log().all()
                .assertThat().statusCode(201);
    }
    @Test
    public void UpdateUser(){
        File body=new File("src\\test\\resources\\UpdateUser.json");
        given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(body)
                .when().patch("/users/2")
                .then().log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void DeleteUser(){
        given().baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .when().delete("/users/2")
                .then().log().all()
                .assertThat().statusCode(204);
    }
}
