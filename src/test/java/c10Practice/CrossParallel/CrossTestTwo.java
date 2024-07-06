package c10Practice.CrossParallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossTestTwo {

    WebDriver driver;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setup(String browserName){
        driver = DriverFactory.createDriver(browserName);
        driver.get("http://dev-hrm.yoll.io/");
    }

    @Test
    public void logoTest() throws InterruptedException {
        WebElement logo = driver.findElement(By.xpath("//*[@id='divLogo']/img"));
        Thread.sleep(2000);
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    void homePageTitle() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        Thread.sleep(2000);
    }

    @AfterClass(alwaysRun = true)
    void tearDown(){
        driver.quit();
    }
}
