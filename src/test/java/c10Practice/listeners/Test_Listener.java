package c10Practice.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Test_Listener implements ITestListener{
	@Override
	public void onTestStart(ITestResult result) {
		// When test method starts
		Reporter.log("onTestStart -> Test Name: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// If test method is successful
		Reporter.log("onTestSuccess -> Test Name: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// If test method is failed
		Reporter.log("onTestFailure -> Test Name: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// If test method is skipped
		Reporter.log("onTestSkipped -> Test Name: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// If test method failed, but within the success percentage requested
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(result));
	}

	@Override
	public void onStart(ITestContext context) {
		// Before <test> tag of xml file
		System.out.println("onStart -> Test Tag Name: " + context.getName());
		ITestNGMethod methods[] = context.getAllTestMethods();
		System.out.println("These methods will be executed in this test tag:");
		for (ITestNGMethod method : methods) {
			Reporter.log(method.getMethodName());
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		// After <test> tag of xml file
		Reporter.log("onFinish -> Test Tag Name: " + context.getName());
	}
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

}
