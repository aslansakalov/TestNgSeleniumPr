package c10Practice.Hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    LoginPage (WebDriver remoteDriver) {
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="txtUsername")
    WebElement userNameInput;

    @FindBy(id="txtPassword")
    WebElement passwordInput;

    @FindBy(id="btnLogin")
    WebElement loginButton;

    @FindBy(id="spanMessage")
    WebElement errorMsg;

    public void loginToHrm(String userName, String password, WebDriver driver){
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
