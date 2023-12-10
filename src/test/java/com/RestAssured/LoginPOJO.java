package com.RestAssured;

public class LoginPOJO {
    private String email;
    private String password;

    public LoginPOJO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginPOJO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
