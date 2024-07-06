package c11Practice.parametrization;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import c11Practice.utility.LocalBrowserManager;

public class CrossBrowserTesting {

    /**
     * navigate to https://bestbuy.com and print Title
     * navigate to https://amazon.com and print Title
     * Navigate to https://facebook.com and print Title
     */

    WebDriver driver;

    @Parameters("browserName")
    @BeforeMethod
    public void beforeEachMethod(@Optional("chrome") String browserValue){

        driver = LocalBrowserManager.createBrowser(browserValue);
    }
    @AfterMethod
    public void afterEachMethod(){
        driver.quit();
    }

    @Test
    public void validateTitleForBestBuy() throws InterruptedException {
        driver.get("https://bestbuy.com");
        Thread.sleep(1000);
        System.out.println("BestBuy title is " + driver.getTitle());

    }

    @Test
    public void validateTitleForAmazon() throws InterruptedException {
        driver.get("https://amazon.com");
        Thread.sleep(1000);
        System.out.println("Amazon title is " + driver.getTitle());
    }

    @Test
    public void validateTitleForFacebook() throws InterruptedException {
        driver.get("https://facebook.com");
        Thread.sleep(1000);
        System.out.println("Facebook title is " + driver.getTitle());
    }





}
