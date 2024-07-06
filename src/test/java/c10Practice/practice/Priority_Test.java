package c10Practice.practice;

import org.testng.annotations.Test;

public class Priority_Test {


    @Test
    public void method1(){
        System.out.println("Priority-->  method1");
    }

    @Test(priority = 1)
    public void method2(){
        System.out.println("Priority-->  method2");
    }
    @Test(priority = 0)

    public void method3(){
        System.out.println("Priority-->  method3");
    }

}
