package c10Practice.test_listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(c10Practice.listeners.Listeners.class)
public class Test_2 {

	@Test
	public void assertMethod() {

		System.out.println("Actual Test");
		Assert.assertTrue(true);

	}
	
	
	@Test
	public void assertMethod2() {

		System.out.println("Actual Test");
		Assert.assertTrue(false);
	
	}
}
