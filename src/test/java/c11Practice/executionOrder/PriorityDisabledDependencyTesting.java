package c11Practice.executionOrder;

import org.testng.Assert;
import org.testng.annotations.*;

public class PriorityDisabledDependencyTesting {

    @Test(priority = 1)
    public void loginWithValidCredentials(){
        System.out.println("        Logging in to HRM with valid credentials");
        Assert.fail("PurposelyFailing");
    }

    @Test(priority = 2, enabled = false)
    public void verifyAvailableTabsInHomePage(){
        System.out.println("        Verify available tabs in HomePage functionality ");
        Assert.assertTrue(false);  // Purposely failing this scenario
    }


    @Test(priority = 3, dependsOnMethods = "loginWithValidCredentials")
    public void logoVerification(){
        System.out.println("        Verify Logo in HomePage");
    }

    @Test(priority = 4, dependsOnMethods = "loginWithValidCredentials")
    public void logOutFromHrmApplication(){
        System.out.println("        Log Out from HRM Application");
    }

    @Test
    void practiceReporting(){
        System.out.println("hello");
    }
}
