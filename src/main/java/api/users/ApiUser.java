package api.users;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.io.File;

public class ApiUser {

    private static final String BASE_URL = "https://thinking-tester-contact-list.herokuapp.com";

    private Headers loginHeaders = new Headers(new Header("Cookie", "token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NmZhYTVmY2FkZWI2MzAwMTMwZDZmYzEiLCJpYXQiOjE3Mjc3MDMyNDB9.HDa3MXa4KYkkQ8iDc9y5bNna1ePnJE_ZYF__2pIjvjU"), new Header("Content-Type", "application/json"));
    private Headers signupHeaders = new Headers(new Header("Cookie", "token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NmZhYmQ0M2FkZWI2MzAwMTMwZDcwN2QiLCJpYXQiOjE3Mjc3MDg0ODN9.xLYoZhnQc8Jn3CcjbsRmbzIWI_CP_ldccDtBrko4xRM"), new Header("Content-Type", "application/json"));


    public void logInUser() {
        RestAssured.given()
                .baseUri(BASE_URL)
                .headers(loginHeaders)
                .body(new File("src/test/resources/userLoginBody.json"))
                .when()
                .post("/users/login")
                .then()
                .statusCode(200);
    }

    public void deleteUser(String userToken){
        RestAssured.given()
                .baseUri(BASE_URL)
                .headers(loginHeaders)
                .header(new Header("Authorization", userToken))
                .when()
                .delete("/users/me")
                .then()
                .statusCode(200);
    }

    public String registerUser(){
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header(new Header("Content-Type", "application/json"))
                .body(new File("src/test/resources/userRegistrationBody.json"))
                .when()
                .post("/users")
                .then()
                .log().all()
                .statusCode(201).extract()
                .body()
                .jsonPath()
                .getString("token");
    }
}
