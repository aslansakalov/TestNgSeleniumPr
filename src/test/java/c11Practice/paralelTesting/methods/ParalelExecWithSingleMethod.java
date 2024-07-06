package c11Practice.paralelTesting.methods;

import org.testng.annotations.*;

public class ParalelExecWithSingleMethod {
    long startTime;
    long endTime;

    @BeforeClass
    public void startOfClass(){
        startTime = System.currentTimeMillis();
    }

    @AfterClass
    public void endOfClass(){
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


    @Test(invocationCount = 3, threadPoolSize = 3)
    public void methodOne() throws InterruptedException {
        System.out.println("Create a chrome driver");
        System.out.println("Navigate to application!!!");
        System.out.println("login to application");
        Thread.sleep(5000);
        System.out.println("logout from application");
    }

    @Test()
    public void methodWithChrome() throws InterruptedException {
        System.out.println("Create a chrome driver");
        System.out.println("Navigate to application!!!");
        System.out.println("login to application");
        Thread.sleep(5000);
        System.out.println("logout from application");
    }
    @Test()
    public void methodWithFireFox() throws InterruptedException {
        System.out.println("Create a firefox driver");
        System.out.println("Navigate to application!!!");
        System.out.println("login to application");
        Thread.sleep(5000);
        System.out.println("logout from application");
    }

}
