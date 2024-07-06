package c11Practice.retryLogic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HrmLoginTest {
    @Test(retryAnalyzer = HRMRetry.class)
    public void test2() {
        Assert.fail("Test is failed");
    }
}
