package c10Practice.Hrm;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class HrmLoginTest {

    private WebDriver driver;
    private String errorMessageText = "Invalid credentials";
    public static LoginPage loginPage;
    public static HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("http://dev-hrm.yoll.io/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(groups = {"Smoke", "Regression"})
    public void verify_logIn_with_valid_credentials() {
        loginPage.loginToHrm("yoll-student", "Bootcamp1#", driver);
        Assert.assertEquals(homePage.welcomeMessage.getText(),"Welcome Yoll");
    }

    @Test(groups ={"Regression"})
    public void verify_logIn_with_invalid_credentials() {
        loginPage.loginToHrm("invalidUsername", "invalidPWD", driver);
        Wait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(loginPage.errorMsg));
        Assert.assertEquals(loginPage.errorMsg.getText(), errorMessageText);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
