package c11Practice.paralelTesting.classes;

import org.testng.annotations.Test;

public class ClassInParallelTwo extends Base {

    @Test()
    public void firstTestMethod() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("First test method from Class Two, ThreadID:" + Thread.currentThread().getId());
    }

    @Test()
    public void secondTestMethod() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Second test method from Class Two, ThreadID:" + Thread.currentThread().getId());
    }
}
