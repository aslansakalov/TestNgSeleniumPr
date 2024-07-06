package c10Practice.Hrm;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iFrameTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com");
        driver.manage().window().maximize();
    }

    @Test
    public void iFrameTest () throws InterruptedException {
        WebElement frameLink = driver.findElement(By.linkText("Frames"));
        frameLink.click();

        WebElement iframeLink = driver.findElement(By.linkText("iFrame"));
        iframeLink.click();

        //switch to iFrame
        WebElement myFrame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(myFrame);

        Thread.sleep(3000);
        WebElement inputBox = driver.findElement(By.xpath("//*[@id='tinymce']/p"));
        inputBox.clear();
        inputBox.sendKeys("This is SPARTAAAAAAA");
        Thread.sleep(5000);

        //go to back to main html
        driver.switchTo().defaultContent();
        WebElement sentence = driver.findElement(By.xpath("//*[@id='content']//h3"));
        Assert.assertEquals(sentence.getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");
    }

    @Test
    public void nestedIframeTest () throws InterruptedException {
        WebElement frameLink = driver.findElement(By.linkText("Frames"));
        frameLink.click();
        Thread.sleep(2000);
        WebElement nestedFrameLink = driver.findElement(By.linkText("Nested Frames"));
        nestedFrameLink.click();
        Thread.sleep(2000);

        /* switch to parent iframe */
        driver.switchTo().frame("frame-top");

        /* switch to child iframe */
        Thread.sleep(2000);
        driver.switchTo().frame("frame-left");
        System.out.println("I have successfully switched to " +
                driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText() + " frame");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
