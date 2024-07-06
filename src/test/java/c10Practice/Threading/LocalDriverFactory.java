package c10Practice.Threading;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocalDriverFactory {
    static WebDriver createInstance(String browserName) {
        WebDriver driver = null;
        if (browserName.toLowerCase().contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
            return driver;
        }
        return driver;
    }
}
