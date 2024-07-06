package c11Practice.paralelTesting.methods;

import org.testng.annotations.*;

public class ParalelMethods {
    long startTime;
    long endTime;

    @BeforeSuite
    public void startOfClass(){
        startTime = System.currentTimeMillis();
    }

    @AfterSuite
    public void endOfClass(){
        endTime = System.currentTimeMillis();
        long totalExecutionTime = endTime - startTime;
        System.out.println("The complete execution took " + totalExecutionTime + " time");
    }
    @Test()
    public void firstTestMethod() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("First test method, ThreadID:" + Thread.currentThread().getId());
    }

    @Test()
    public void secondTestMethod() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Second test method, ThreadID:" + Thread.currentThread().getId());
    }
}
