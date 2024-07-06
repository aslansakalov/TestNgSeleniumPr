package c11Practice.paralelTesting.test;

import org.testng.annotations.*;

public class ParalelExecOnTest {
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

    }
    @AfterMethod
    public void afterEachMethod(){
        System.out.println("Kill the existing driver");
    }


    @Parameters("browser")
    @Test()
    public void methodWithChromeOrFireFox(String browserName) throws InterruptedException {
        System.out.println("Create a " + browserName + " driver");
        System.out.println("Navigate to application!!!");
        System.out.println("login to application");
        Thread.sleep(5000);
        System.out.println("logout from application");
    }


}
