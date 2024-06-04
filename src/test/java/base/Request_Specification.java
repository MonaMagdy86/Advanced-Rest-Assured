package base;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Request_Specification {
    public static RequestSpecification getReqSpec(){
   RequestSpecification request=  given()
           .baseUri("https://jsonplaceholder.typicode.com")
           .contentType(ContentType.JSON)
           .log().all();
        return request;
    }
}
