package c10Practice.test_listeners;

import c10Practice.listeners.Test_Listener;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Test_Listener.class)
public class Test_3 extends Test_Listener {
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
		Assert.assertTrue(true);

	}
	private int i=0;
	@Test(successPercentage=60, invocationCount=5)
	public void method3() {
		i++;
		System.out.println("method3, invocation count: " + i);
		if (i <3) {
			System.out.println("method3!");
			Assert.assertEquals(i, 5);
		}
	}

}


