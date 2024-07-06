package c10Practice.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumParallel_Test {


    public WebDriver driver=null;

    @BeforeClass
    @Parameters({"browser"})
    public void prepareTest(String browser){

        driver=BrowserFactory.creatInstance(browser);
        DriverFactory.getInstance().setDriver(driver);
        driver=DriverFactory.getInstance().getDriver();

    }
    @Test
    @Parameters({"search"})
    void parallelSearch(String search) throws InterruptedException {
        driver.get("http://www.google.com");
        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys(search);
        Thread.sleep(3000);
        searchBox.sendKeys(Keys.ENTER);
        System.out.println("Print Thread Name: "+Thread.currentThread().getName());
    }
    @AfterClass
    void endTest() throws InterruptedException {
        Thread.sleep(8000);
        DriverFactory.getInstance().removeDriver();
    }


    }

