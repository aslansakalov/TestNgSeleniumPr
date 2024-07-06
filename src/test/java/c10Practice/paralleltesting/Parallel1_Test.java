package c10Practice.paralleltesting;

import org.testng.annotations.Test;

public class Parallel1_Test {

        @Test
        public void testMethod1() throws InterruptedException {
            System.out.println("Parallel1 -> testMethod1");
            Thread.sleep(3000);
            System.out.println("Parallel1 -> testMethod1 -> More Steps");
        }

        @Test
        public void testMethod2() throws InterruptedException {
            System.out.println("Parallel1 -> testMethod2");
            Thread.sleep(3000);
            System.out.println("Parallel1 -> testMethod2 -> More Steps");
        }

}
