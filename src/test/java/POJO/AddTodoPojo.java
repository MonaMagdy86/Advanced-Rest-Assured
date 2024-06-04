package POJO;

public class AddTodoPojo {
    private String id;
    private String userId;
    private String title;
    boolean completed;
public AddTodoPojo(){}
    public AddTodoPojo(String id, String userId, String title,boolean completed) {
        this.id=id;
        this.userId = userId;
        this.title = title;
        this.completed=completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
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
}
