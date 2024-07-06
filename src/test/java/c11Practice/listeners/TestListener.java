package c11Practice.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("This is good!!!!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("This not good because the test case ==> " + result.getName() + " is failed!!!!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("Whattttttt?");
    }
}
