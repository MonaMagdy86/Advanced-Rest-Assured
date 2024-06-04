package testcases;

import POJO.AddCommentPojo;
import apis.commentsApis;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
@Feature("Comments Feature")
public class CommentsTest {
    @Story("Get All Comments")
    @Test(description = "Get All Comments")
    public void getAllComments(){
        Response response = commentsApis.getAllComments();
        assertThat(response.statusCode(),equalTo(200));
    }
    @Story("Get All Comments For a Specific Post")
    @Test(description = "Get All Comments For a Specific Post")
    public void getAllCommentsForSpecificPost(){
        Response response=commentsApis.getAllCommentsForSpecificPost();

        assertThat(response.statusCode(),equalTo(200));
    }
    @Story("Get a Single Comment")
    @Test(description = "Get a Single Comment")
    public void getSingleComment(){
        Response response=commentsApis.getSingleComment();

        AddCommentPojo returnedComment=response.body().as(AddCommentPojo.class);
       assertThat(response.statusCode(),equalTo(200));
        assertThat(returnedComment.getEmail(),equalTo("Jayne_Kuhic@sydney.com"));
    }
    @Story("Add a Comment")
    @Test(description = "Add a Comment")
    public void addComment(){
        AddCommentPojo addComment=new AddCommentPojo("501","2","mona comment","mona@sydney.com","mona comment body");
       Response response=commentsApis.addComment(addComment);

        AddCommentPojo returnedComment=response.body().as(AddCommentPojo.class);

        assertThat(response.statusCode(),equalTo(201));
        assertThat(returnedComment.getBody(),equalTo(addComment.getBody()));
        assertThat(returnedComment.getEmail(),equalTo(addComment.getEmail()));


    }
    @Story("Delete a Comment")
    @Test(description = "Delete a Comment")
    public void deleteComment(){
        Response response=commentsApis.deleteComment();

        assertThat(response.statusCode(),equalTo(200));
    }
}
