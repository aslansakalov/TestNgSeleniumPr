package c11Practice.grouping;

import org.testng.annotations.Test;

public class HomePageTest {

    @Test(groups = {"smoke", "regression"})
    public void verifyAvailableTabsInHomePage(){
        System.out.println("      Verify tabs in HomePage");
    }

    @Test(groups = {"smoke", "regression"})
    public void logoVerificationInHomePage(){
        System.out.println("        Verify Logo in HomePage");
    }

    @Test(groups = {"regression"})
    public void subscribeButtonValidation() {
        System.out.println("        Verify Logo in HomePage");
    }

    @Test(groups = {"smoke", "regression"})
    public void logOutFromHrmApplication(){
        System.out.println("        Log Out from HRM Application");
    }

    @Test
    public void footerValidation(){
        System.out.println("This is footer validation");
    }

}
