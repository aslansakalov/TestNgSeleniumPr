package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class Base {
    @Parameters("browserName")
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browserName) throws InterruptedException {
        WebDriver driver = LocalBrowserManager.createBrowser(browserName);
        LocalDriverManager.setWebDriver(driver);
        LocalDriverManager.getDriver().manage().window().maximize();
        LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        LocalDriverManager.getDriver().manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
        LocalDriverManager.getDriver().get("http://dev-hrm.yoll.io/index.php/auth/validateCredentials");
    }
    @AfterMethod
    public void afterMethod(){
        LocalDriverManager.removeDriver();
    }

}
