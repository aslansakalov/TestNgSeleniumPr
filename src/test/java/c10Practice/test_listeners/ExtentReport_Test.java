package c10Practice.test_listeners;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import c10Practice.listeners.ExtentReport_Listener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExtentReport_Listener.class)
public class ExtentReport_Test extends ExtentReport_Listener {




	ExtentReports report;
	ExtentTest test;

	@Test
	public void method1() {

		System.out.println("Actual Test");
		Assert.assertTrue(true);
	//	test.log(LogStatus.INFO,"method1 started");
	//	test.log(LogStatus.PASS," Test passed");

	}
	@Test
	public void method2() {

		System.out.println("Actual Test 2");
		Assert.assertTrue(false);
//		test.log(LogStatus.INFO,"method2 started");
//		test.log(LogStatus.FAIL," Test Failed");
	}

}
