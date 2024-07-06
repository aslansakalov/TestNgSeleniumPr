package c10Practice.test_listeners;

import c10Practice.listeners.Method_Listener;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Method_Listener.class)
public class Method_L_Test {
	Reporter report;

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

}
