package c10Practice.test_listeners;


import c10Practice.listeners.Method_Listener;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_1 extends Method_Listener {


	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest

	public void afterTest() {
		System.out.println("After Test");
	}


	@Test
	public void method1() {

		System.out.println("Actual Test");
		Assert.assertTrue(true);

	}
	@Test
	public void method2() {

		System.out.println("Actual Test 2");
		Assert.assertTrue(false);

	}
	
	@AfterMethod

	public void afterMethod(ITestResult testResult) {
		System.out.println("After Method");
		
		if(testResult.getStatus()==ITestResult.FAILURE) {
			System.out.println("Failed: "+ testResult.getMethod().getMethodName());
		}
		
		if(testResult.getStatus()==ITestResult.SUCCESS) {
		
		System.out.println("Sucess: "+testResult.getMethod().getMethodName());
		}
	}
}
