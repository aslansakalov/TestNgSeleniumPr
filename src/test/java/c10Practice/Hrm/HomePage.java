package c10Practice.Hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    HomePage (WebDriver remoteDriver) {
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="welcome")
    WebElement welcomeMessage;
}
