package c10Practice.paralleltesting;

import org.testng.annotations.Test;

public class SingleMethodParallel_Test {


  @Test(invocationCount = 3)
  public void test2() {
	  Thread.currentThread().setName("Thread-test2");
	  System.out.println("From Test 2 :"+Thread.currentThread().getName()+" Thread id:"+Thread.currentThread().getId());
  }

  
  
}
