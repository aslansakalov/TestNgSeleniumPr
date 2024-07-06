package c10Practice.Assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstTest {


    public static void main(String[] args) {

        //Setup our webdriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
