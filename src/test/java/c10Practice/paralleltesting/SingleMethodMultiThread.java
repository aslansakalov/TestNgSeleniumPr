package c10Practice.paralleltesting;

import org.testng.annotations.*;

public class SingleMethodMultiThread {
	

  @Test(threadPoolSize=1, invocationCount=3,timeOut=1000)
  public void test1() {
	  Thread.currentThread().setName("Cohort4-test1");
	  System.out.println("From Test 1 :"+ Thread.currentThread().getName()+ " Thread id:"+Thread.currentThread().getId());
  }
  
 
  @Test(invocationCount = 3)
  public void test2() {
	  Thread.currentThread().setName("Thread-test2");
	  System.out.println("From Test 2 :"+Thread.currentThread().getName()+" Thread id:"+Thread.currentThread().getId());
  }
  
  @Test(threadPoolSize = 3,invocationCount = 3)
  public void test3() throws InterruptedException {
	  Thread.currentThread().setName("Thread-test3");
      Thread.sleep(5000);
	  System.out.println("From Test 3 :"+Thread.currentThread().getName()+" Thread id:"+Thread.currentThread().getId());
  }
    long startTime;
    long endTime;

    @BeforeClass
    public void startOfSuite(){
        startTime = System.currentTimeMillis();
    }

    @AfterClass
    public void endOfSuite(){
        endTime = System.currentTimeMillis();
        long totalExecutionTime = endTime - startTime;
        System.out.println("The complete execution took " + totalExecutionTime + " time");
    }
  
  
}
