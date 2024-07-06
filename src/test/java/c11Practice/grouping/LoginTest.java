package c11Practice.grouping;

import org.testng.annotations.Test;

public class LoginTest {

    @Test(groups = {"smoke", "regression"})
    public void loginWithValidCredentials(){
        System.out.println("        Logging in to HRM with valid credentials");
    }

    @Test(groups = {"regression"})
    public void loginWithInValidCredentials(){
        System.out.println("        Logging in to HRM with invalid credentials");
    }

    @Test(groups = {"smoke", "regression"})
    public void logoVerificationInLoginPage(){
        System.out.println("        Verify Logo in LoginPage");
    }
}
