package c11Practice.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalBrowserManager {

    public static WebDriver createBrowser(String browserValue) {
        WebDriver driver = null;

        if (browserValue.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserValue.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

}
