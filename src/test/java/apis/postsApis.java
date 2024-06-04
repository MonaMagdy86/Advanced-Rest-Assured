package apis;

import POJO.AddPostPojo;
import base.Request_Specification;
import data.Route;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static io.restassured.RestAssured.given;

public class postsApis {
    public static Response getAllPosts(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .get(Route.POSTS_ROUTE)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response getSinglePost(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .get(Route.POSTS_ROUTE+"/"+30)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response addPost( AddPostPojo addPost){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .body(addPost)
                .when()
                .post(Route.POSTS_ROUTE)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response modifyPost( AddPostPojo modifyPost){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .body(modifyPost)
                .when()
                .patch(Route.POSTS_ROUTE+"/"+30)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response updatePost(AddPostPojo updatePost){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .body(updatePost)
                .when()
                .put(Route.POSTS_ROUTE+"/"+50)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response deletePost(){
        return  given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .delete(Route.POSTS_ROUTE+"/"+30)
                .then()
                .log().all()
                .extract().response();
    }
}
