package c10Practice.listeners;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class Method_Listener implements IInvokedMethodListener {

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("BeforeInvoke: "+ testResult.getTestClass().getName()+" ==> "+method.getTestMethod().getMethodName());
		 
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("AfterInvoke: "+ testResult.getTestClass().getName()+" ==> "+method.getTestMethod().getMethodName());
		
	}

}
