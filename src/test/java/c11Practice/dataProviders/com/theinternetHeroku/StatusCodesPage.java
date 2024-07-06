package c11Practice.dataProviders.com.theinternetHeroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StatusCodesPage {

    WebDriver driver;

    @BeforeMethod
    public void beforeEachMethod(){
        System.out.println("-----------");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");
    }
    @AfterMethod
    public void afterEachMethod(){
        driver.quit();
    }

    /**
     * Validation of status code and respective message
     * 200, This page returned a 200 status code.
     * 301, This page returned a 301 status code.
     * 404, This page returned a 404 status code.
     * 500, This page returned a 500 status code.
     */

    @Test(dataProvider = "statusCodes", dataProviderClass = TestData.class)
    public void statusCodeValidation(String statusCode, String expectedMessage) throws InterruptedException {
        String xpath = "//*[text() = '" + statusCode + "']";
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(5000);

        String actualMessage = driver.findElement(
                By.xpath("//*[text() = 'Status Codes']/..//p")).getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage), "Status code message validation failed!!");
    }



}
