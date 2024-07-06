package c11Practice.paralelTesting.classes;

import org.testng.annotations.*;

public class Base {
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
    public void startOfMethod(){
        System.out.println("startOfMethod");
    }

    @AfterMethod
    public void endOfMethod(){
        System.out.println("endOfMethod");
    }
    @BeforeClass
    public void startOfClass(){
        System.out.println("startOfClass");
    }

    @AfterClass
    public void endOfClass(){
        System.out.println("endOfClass");
    }

}
