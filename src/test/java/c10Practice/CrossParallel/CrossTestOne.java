package c10Practice.CrossParallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossTestOne {

    WebDriver driver;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setup(String browserName){
        driver = DriverFactory.createDriver(browserName);
        driver.get("http://dev-hrm.yoll.io/");
    }

    @Test
    void loginTest() throws InterruptedException  {
        driver.findElement(By.id("txtUsername")).sendKeys("yoll-student");
        driver.findElement(By.id("txtPassword")).sendKeys("Bootcamp1#");
        driver.findElement(By.id("btnLogin")).click();
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    @AfterTest(alwaysRun = true)
    void tearDown(){
        driver.quit();
    }



}
