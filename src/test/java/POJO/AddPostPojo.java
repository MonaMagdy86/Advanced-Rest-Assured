package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class AddPostPojo {
    private  String id;
private  String userId;
   private String title;

    private String body;
public AddPostPojo(){

}
    public AddPostPojo(String title, String body, String userId,String id) {
        this.title = title;
        this.body = body;
        this.userId=userId;
        this.id=id;
    }


    public AddPostPojo(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {

    return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
