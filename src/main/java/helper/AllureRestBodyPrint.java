package helper;

import io.qameta.allure.Allure;
import io.restassured.path.json.JsonPath;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class AllureRestBodyPrint {


    public AllureRestBodyPrint(String name, String jsonFilePath){
        String requestBody = null;
        try {
            requestBody = new String(Files.readAllBytes(new File(jsonFilePath).toPath()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Allure.addAttachment(name, new ByteArrayInputStream(requestBody.getBytes(StandardCharsets.UTF_8)));
    }

    public AllureRestBodyPrint(String name, JsonPath responseBody){
        Allure.addAttachment(name, responseBody.prettyPrint());
    }


}
