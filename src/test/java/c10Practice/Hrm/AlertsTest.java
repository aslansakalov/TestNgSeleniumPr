package c10Practice.Hrm;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
    }

    @Test
    public void alertTest () throws InterruptedException {
        WebElement clickMeBtn = driver.findElement(By.id("promtButton"));
        clickMeBtn.click();

        //Create alert object
        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();
        String expectedAlertText = "Please enter your name";

        Thread.sleep(2000);
        Assert.assertEquals(actualAlertText, expectedAlertText);

        //send some text to alert
        alert.sendKeys("This is SPARTAAAAAAAAA");
        Thread.sleep(5000);

        //accept the alert
        alert.accept();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.id("promptResult")).getText().contains("This is SPARTAAAAAAAAA"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
