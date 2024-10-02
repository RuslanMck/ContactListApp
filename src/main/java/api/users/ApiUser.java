package api.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UserDto;
import helper.AllureRestBodyPrint;
import io.qameta.allure.Allure;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.testng.Assert;
import patterns.ResponsePatterns;

import java.io.File;
import java.util.regex.Pattern;

public class ApiUser {

    private static final String BASE_URL = "https://thinking-tester-contact-list.herokuapp.com";
    private static String userToken = null;


    public ApiUser() {
        requestSpecification();
    }

    private RequestSpecification requestSpecification;

    private void requestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build();
    }

    @SneakyThrows
    public String logInWithParams(String email, String password){
        JsonPath responseBody = RestAssured.given()
                .filter(new AllureRestAssured())
                .spec(requestSpecification)
                .body(new File("src/test/resources/userLoginBody.json"))
                .when()
                .post("/users/login")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        UserDto registrationResponseBody = new ObjectMapper().readValue(responseBody.prettyPrint(), UserDto.class);
        return registrationResponseBody.getToken();
    }


    public void logInUser() {

        new AllureRestBodyPrint("Login User Request Body", "src/test/resources/userLoginBody.json");
        JsonPath responseBody = RestAssured.given()
                .filter(new AllureRestAssured())
                .spec(requestSpecification)
                .body(new File("src/test/resources/userLoginBody.json"))
                .when()
                .post("/users/login")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        new AllureRestBodyPrint("Login User Response Body", responseBody);
    }

    public void deleteUser(String userToken) {
        RestAssured.given()
                .filter(new AllureRestAssured())
                .spec(requestSpecification)
                .header(new Header("Authorization", userToken))
                .when()
                .delete("/users/me")
                .then()
                .statusCode(200);
    }

    @SneakyThrows
    public String registerUser() {

        new AllureRestBodyPrint("Registration Request Body", "src/test/resources/userRegistrationRequestBody.json");

        JsonPath responseBody = RestAssured.given()
                .filter(new AllureRestAssured())
                .spec(requestSpecification)
                .body(new File("src/test/resources/userRegistrationRequestBody.json"))
                .when()
                .post("/users")
                .then()
                .statusCode(201).extract()
                .body()
                .jsonPath();

        UserDto registrationResponseBody = new ObjectMapper().readValue(responseBody.prettyPrint(), UserDto.class);

        Assert.assertTrue(Pattern.matches(ResponsePatterns.TOKEN_PATTERN, registrationResponseBody.getToken()), "Token doesn't match expected pattern.");
        Assert.assertTrue(Pattern.matches(ResponsePatterns.FIRST_NAME_PATTERN, registrationResponseBody.getUser().getFirstName()), "First Name doesn't match expected pattern.");
        Assert.assertTrue(Pattern.matches(ResponsePatterns.LAST_NAME_PATTERN, registrationResponseBody.getUser().getLastName()), "Last Name doesn't match expected pattern.");
        Assert.assertTrue(Pattern.matches(ResponsePatterns.EMAIL_PATTERN, registrationResponseBody.getUser().getEmail()), "Email doesn't match expected pattern.");

        userToken = registrationResponseBody.getToken();

        new AllureRestBodyPrint("Registration Response Body", responseBody);

        return userToken;
    }

}
