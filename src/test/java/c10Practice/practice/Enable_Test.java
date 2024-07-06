package c10Practice.practice;

import org.testng.annotations.Test;

public class Enable_Test {
    @Test(enabled=false)
    public void testMethod1() {
        System.out.println("EnableDisableTimeout--> testMethod1");
    }


    // if we know load time of our service and want to check performance of our APIs we can apply timeout
    @Test(timeOut =3000, enabled = false)
    public void testMethod2() throws InterruptedException {
        System.out.println("EnableDisableTimeout--> testMethod2");
        Thread.sleep(4000);
    }

    @Test
    public void testMethod3() {
        System.out.println("EnableDisableTimeout-->testMethod3");
    }

    @Test
    public void testMethod4() {
        System.out.println("EnableDisableTimeout--> testMethod4");
    }
}
