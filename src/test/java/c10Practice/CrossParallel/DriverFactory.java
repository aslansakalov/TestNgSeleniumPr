package c10Practice.CrossParallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver createDriver(String browserName){
        //if the browser is firefox, then create firefox driver
        if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            driver = new FirefoxDriver();
        }
        //if browser is chrome, then create chrome driver
        else if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }

}
