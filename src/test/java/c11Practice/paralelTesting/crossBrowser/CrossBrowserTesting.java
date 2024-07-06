package c11Practice.paralelTesting.crossBrowser;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import c11Practice.utility.LocalDriverManager;

public class CrossBrowserTesting {

    /**
     * navigate to https://bestbuy.com and print Title
     * navigate to https://amazon.com and print Title
     * Navigate to https://facebook.com and print Title
     */

    WebDriver driver;

    @Test
    public void validateTitleForBestBuy() throws InterruptedException {
        LocalDriverManager.getDriver().get("https://bestbuy.com");
        Thread.sleep(1000);
        System.out.println("BestBuy title is " + LocalDriverManager.getDriver().getTitle());

    }

    @Test
    public void validateTitleForAmazon() throws InterruptedException {
        LocalDriverManager.getDriver().get("https://amazon.com");
        Thread.sleep(1000);
        System.out.println("Amazon title is " + LocalDriverManager.getDriver().getTitle());
    }

    @Test
    public void validateTitleForFacebook() throws InterruptedException {
        LocalDriverManager.getDriver().get("https://facebook.com");
        Thread.sleep(1000);
        System.out.println("Facebook title is " + LocalDriverManager.getDriver().getTitle());
    }





}
