package c10Practice.listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.Arrays;

public class ExtentReport_Listener implements ITestListener {

	protected static ExtentReports reports;
	protected static ExtentTest test;

	protected static String resultpath = getResultPath();
	
	
/**
 * @param directory
 * @description
 * 
 */
	public static void deleteDirectory(File directory) {
		if (directory.exists()) {
			File[] files = directory.listFiles();
			if (null != files) {
				for (int i = 0; i < files.length; i++) {

					System.out.println(files[i].getName());
					if (files[i].isDirectory()) {
						deleteDirectory(files[i]);
					} else {
						files[i].delete();
					}
				}

			}
		}

	}

	private static String getResultPath() {
		resultpath = "test";// new SimpleDateFormat
		if (!new File(resultpath).isDirectory()) {
			new File(resultpath);
		}
		return resultpath;
	}

	String ReportLocation = "test-output/Reports/" + resultpath + "/";

	
	public void onTestStart(ITestResult result) {
		// When test method starts
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName());
		System.out.println(result.getTestClass().getTestName());
		System.out.println(result.getMethod().getMethodName());
	}

	
	public void onTestSuccess(ITestResult result) {
		// If test method is successful

		test.log(LogStatus.PASS, "Test passed");
		//test.log(LogStatus.PASS,result.getMethod().getMethodName());
	}


	public void onTestFailure(ITestResult result) {
		// If test method is failed
		String exceptionMessage= Arrays.toString(result.getThrowable().getStackTrace());

		test.log(LogStatus.FAIL, result.getThrowable().getMessage());
		test.log(LogStatus.FAIL,"Test Failed");

	//	test.log("<details>"+"<summary>"+"<b>"+"<front color="+"red>"+"Exception Occured: Click to see"+"</b>"+"</summary>"+"<b>"+result.getThrowable().getMessage()+"</b>"+""+exceptionMessage.replaceAll(",","<br>")+"</details>"+"\n");
	}

	
	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, "Test skipped");

		
	}

	public void onStart(ITestContext context) {
		// Before <test> tag of xml file

		System.out.println(ReportLocation + " ReportLocation");
		reports = new ExtentReports(ReportLocation + "ExtentReport.html");
		test = reports.startTest("");
	}

	
	public void onFinish(ITestContext context) {
		// After <test> tag of xml file
		reports.endTest(test);
		reports.flush();
	}

}
