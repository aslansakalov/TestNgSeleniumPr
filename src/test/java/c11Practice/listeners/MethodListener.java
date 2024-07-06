package c11Practice.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.*;
import c11Practice.utility.LocalBrowserManager;
import c11Practice.utility.LocalDriverManager;

public class MethodListener implements IInvokedMethodListener {

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// Before every method in the Test Class
		Reporter.log("beforeInvocation: " + testResult.getTestClass().getName() + " => "
				+ method.getTestMethod().getMethodName());

		if (method.isTestMethod()) {
			String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
			WebDriver driver = LocalBrowserManager.createBrowser(browserName);  // new ChromeDriver
			LocalDriverManager.setWebDriver(driver);
		}
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// After every method in the Test Class
		Reporter.log("afterInvocation: " + testResult.getTestClass().getName() + " => "
				+ method.getTestMethod().getMethodName());

		if (method.isTestMethod()) {
			WebDriver driver = LocalDriverManager.getDriver();
			if (driver != null) {
				driver.quit();
			}
		}
	}

}
