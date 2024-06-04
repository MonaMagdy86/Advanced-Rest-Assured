package testcases;

import POJO.AddPostPojo;
import apis.postsApis;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
//import javafx.geometry.Pos;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
@Feature("Posts Feature")
public class PostsTest {
    @Story("Get All Posts")
    @Test(description = "Get All Posts")
    public void getAllPosts(){
    Response response=postsApis.getAllPosts();

        assertThat(response.statusCode(),equalTo(200));
    }
    @Story("Get a Single Post")
    @Test(description = "Get a Single Post")
    public void getSinglePost(){
    Response response=postsApis.getSinglePost();

        AddPostPojo returnedPost =response.body().as(AddPostPojo.class);

        assertThat(response.statusCode(),equalTo(200));
        assertThat(returnedPost.getTitle(),equalTo("a quo magni similique perferendis"));
    }
    @Story("Modify a Post")
    @Test(description = "Modify a Post")
    public void modifyPost(){
        AddPostPojo modifyPost=new AddPostPojo("Mona");
        Response response=postsApis.modifyPost(modifyPost);

       AddPostPojo returnedPost=response.body().as(AddPostPojo.class);

       assertThat(returnedPost.getTitle(),equalTo("Mona"));
        assertThat(response.statusCode(),equalTo(200));
    }
    @Story("Update a Post")
    @Test(description = "Update a Post")
    public void updatePost(){
    AddPostPojo updatePost=new AddPostPojo("post title","post body","6","55");
       Response response=postsApis.updatePost(updatePost);

        AddPostPojo returnedPost=response.body().as(AddPostPojo.class);

        assertThat(response.statusCode(),equalTo(200));
        assertThat(returnedPost.getTitle(),equalTo(updatePost.getTitle()));
    }
    @Story("Add a Post")
    @Test(description = "Add a Post")
    public void AddPost(){
        AddPostPojo addPost=new AddPostPojo("Mona","Magdy","3","101");
        Response response=postsApis.addPost(addPost);

        AddPostPojo returnedPost=response.body().as(AddPostPojo.class);

        assertThat(response.statusCode(),equalTo(201));
        assertThat(returnedPost.getTitle(),equalTo(addPost.getTitle()));
        assertThat(returnedPost.getBody(),equalTo(addPost.getBody()));

    }
    @Story("Delete a Post")
    @Test(description = "Delete a Post")
    public void deletePost(){
    Response response= postsApis.deletePost();

        assertThat(response.statusCode(),equalTo(200));
    }
}
