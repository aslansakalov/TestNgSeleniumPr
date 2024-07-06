package c10Practice.Hrm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class HrmEmployeeTest {

    WebDriver driver;
    public static LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("http://dev-hrm.yoll.io/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.loginToHrm("yoll-student", "Bootcamp1#", driver);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    @Test(groups = "Regression")
    public void addEmployee() throws InterruptedException {
        //Create variables to store your test data
        String firstName = "Julie";
        String middleName = "Jr";
        String lastName = "Kings";
        String empId ="";
        // Go to add employee page
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
//        Thread.sleep(1000);
        driver.findElement(By.id("menu_pim_addEmployee")).click();
//        Thread.sleep(3000);
        //Enter employee info
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("middleName")).sendKeys(middleName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        WebElement empIdelem = driver.findElement(By.id("employeeId"));
        //Confirm that employee id is not empty
        empId = empIdelem.getAttribute("value");
        Assert.assertNotNull(empId);
        //Save employee
        driver.findElement(By.id("btnSave")).click();
       Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.id("personal_txtEmpMiddleName")).getAttribute("value"), middleName);
        Assert.assertEquals(driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value"), empId);
        Thread.sleep(2000);
    }
}
