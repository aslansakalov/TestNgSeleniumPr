package c11Practice.listeners;

import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class PracticeLoginTest {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Create a browser");
		System.out.println("Navigate to application");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Kill the browser");
	}


	@Test
	public void validCredentials() {

		System.out.println("Type valid username");
		System.out.println("Type valid pwd");
		System.out.println("Click the login button");

		System.out.println("Home page validation is OK");
		Assert.assertTrue(true);

	}
	@Test
	public void invalidCredentials() {
		System.out.println("Type invalid username");
		System.out.println("Type invalid pwd");
		System.out.println("Click the login button");
		System.out.println("Error message validation failed");
		Assert.assertTrue(false);

	}

	@Test(dependsOnMethods = {"invalidCredentials"})
	public void testThatDependsOnInvalidCredentials() {
		// it will get skipped, because invalidCredentials() is failing
	}

}


