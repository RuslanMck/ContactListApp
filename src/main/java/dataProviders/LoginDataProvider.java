package dataProviders;

import org.testng.annotations.DataProvider;


public class LoginDataProvider {

    private final String VALID_TEST_USERNAME_1 = "username1";
    private final String VALID_TEST_USERNAME_2 = "username2";
    private final String VALID_TEST_USERNAME_3 = "username3";
    private final String VALID_TEST_PASSWORD_1 = "123qwe!";
    private final String VALID_TEST_PASSWORD_2 = "123qwe!2";
    private final String VALID_TEST_PASSWORD_3 = "123qwe!3";



    @DataProvider(name="loginAndPasswordTestData")
    public Object[][] loginAndPasswordData(){
        return new Object[][]{{VALID_TEST_USERNAME_1, VALID_TEST_PASSWORD_1}};
    }

    @DataProvider(name = "usernameTestData")
    public Object[][] loginData(){
        return new Object[][]{{VALID_TEST_USERNAME_1},{VALID_TEST_USERNAME_2},{VALID_TEST_USERNAME_3}};
    }

    @DataProvider(name = "passwordTestData")
    public Object[][] passwordData(){
        return new Object[][]{{VALID_TEST_PASSWORD_1}, {VALID_TEST_PASSWORD_2}, {VALID_TEST_PASSWORD_3}};
    }
}
