package c11Practice.paralelTesting.classes;

import org.testng.annotations.*;

public class HomePageTest {
    long startTime;
    long endTime;

    @BeforeSuite
    public void startOfSuite(){
        startTime = System.currentTimeMillis();
    }

    @AfterSuite
    public void endOfSuite(){
        endTime = System.currentTimeMillis();
        long totalExecutionTime = endTime - startTime;
        System.out.println("The complete execution took " + totalExecutionTime + " time");
    }

    @BeforeMethod
    public void beforeEachMethod(){
        System.out.println("-----------");
        System.out.println("Create a chrome driver");
        System.out.println("Navigate to application!!!");
        System.out.println("Login to application");
    }
    @AfterMethod
    public void afterEachMethod(){
        System.out.println("logout from application");
        System.out.println("Kill the existing driver");
    }


    @Test()
    public void availableTabValidation() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Validate available tabs");
    }

    @Test()
    public void logoValidation() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Validate logo is displayed");
    }

    @Test()
    public void usernameInHomePageValidation() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Validate username is displayed in HomePage");
    }


}
