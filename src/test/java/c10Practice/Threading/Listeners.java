package c10Practice.Threading;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements IInvokedMethodListener, ITestListener, ISuiteListener {



    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // Before every method in the Test Class
        Reporter.log("beforeInvocation: " + testResult.getTestClass().getName() + " => "
                + method.getTestMethod().getMethodName());

        if (method.isTestMethod()) {
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            WebDriver driver = LocalDriverFactory.createInstance(browserName);
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

    @Override
    public void onTestStart(ITestResult result) {
        // When test method starts
        System.out.println(result.getTestClass().getTestName());
        System.out.println(result.getMethod().getMethodName());
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
        Reporter.log("TestCases Skipped and Details are = "+ result.getName(), true);


    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Ignore this
    }

    @Override
    public void onStart(ITestContext context) {
        // Before <test> tag of xml file

        Reporter.log("onStart -> Test Tag Name: " + context.getName());
        ITestNGMethod methods[] = context.getAllTestMethods();
        Reporter.log("These methods will be executed in this test tag:");
        for (ITestNGMethod method : methods) {
            Reporter.log(method.getMethodName());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        // After <test> tag of xml file
        Reporter.log("onFinish -> Test Tag Name: " + context.getName());
    }

    @Override
    public void onStart(ISuite suite) {
        // When <suite> tag starts
        Reporter.log("onStart: before suite starts");
    }

    @Override
    public void onFinish(ISuite suite) {
        // When <suite> tag completes
        Reporter.log("onFinish: after suite completes");
    }

}
