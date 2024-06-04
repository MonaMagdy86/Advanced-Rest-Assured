package apis;

import POJO.AddCommentPojo;
import base.Request_Specification;
import data.Route;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class commentsApis {
    public static Response getAllComments(){
        return given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .get(Route.COMMENTS_ROUTE)
                .then()
                .assertThat()
                .log().all()
                .extract().response();
    }
    public static Response getAllCommentsForSpecificPost(){
        return given()
                .spec(Request_Specification.getReqSpec())
                .param("postId","3")
                .when()
                .get(Route.COMMENTS_ROUTE)
                .then()
                .assertThat()
                .log().all()
                .extract().response();
    }
    public static Response getSingleComment(){
        return given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .get(Route.COMMENTS_ROUTE+"/"+2)
                .then()
                .assertThat()
                .log().all()
                .extract().response();
    }
    public static Response addComment( AddCommentPojo addComment){
        return given()
                .spec(Request_Specification.getReqSpec())
                .body(addComment)
                .when()
                .post(Route.COMMENTS_ROUTE)
                .then()
                .assertThat()
                .log().all()
                .extract().response();
    }
    public static Response deleteComment(){
        return given()
                .spec(Request_Specification.getReqSpec())
                .when()
                .delete(Route.COMMENTS_ROUTE+"/"+55)
                .then()
                .assertThat()
                .log().all()
                .extract().response();
    }
}
