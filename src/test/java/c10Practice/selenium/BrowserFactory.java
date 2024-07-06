package c10Practice.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static WebDriver creatInstance(String browser) {


        WebDriver driver = null;

        try {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);

            }else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                FirefoxOptions options = new FirefoxOptions();
               // options.addArguments("--start-maximized");
                driver = new FirefoxDriver(options);

            }else if(browser.equalsIgnoreCase(("safari"))){
                System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");

                driver=new SafariDriver();
              // driver.manage().window().maximize();

            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return driver;
    }
}
