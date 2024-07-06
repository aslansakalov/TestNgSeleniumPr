package c10Practice.listeners;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportLogs {
	
	@BeforeClass
	public void setUp() {
		Reporter.log("ReportLogs -> This runs once before class", true);
	}
	
	@AfterClass
	public void cleanUp() {
		Reporter.log("ReportLogs -> This runs once after class", true);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("ReportLogs -> This runs before every method", true);
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("ReportLogs -> This runs after every method", true);
	}
	
	@Test
	public void testMethod1() {
		Reporter.log("ReportLogs -> testMethod1", true);
	}
	
	@Test
	public void testMethod2() {
		Reporter.log("ReportLogs -> testMethod2", true);
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods={ "testMethod2" })
	public void testMethod3() {
		Reporter.log("ReportLogs -> testMethod3", true);
	}
}