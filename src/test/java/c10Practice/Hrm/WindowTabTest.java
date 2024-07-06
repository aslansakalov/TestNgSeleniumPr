package c10Practice.Hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WindowTabTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
    }

    @Test
    public void handleNewBrowserWindow () throws InterruptedException {
        /* print the title of original window */
        Thread.sleep(2000);
        System.out.println(driver.getTitle());

        /* store the current window handle */
        String windowHandleBefore = driver.getWindowHandle();

        /* perform the click operation that opens new window */
        Thread.sleep(2000);
        driver.findElement(By.id("windowButton")).click();

        /* switch to new window opened */
        Thread.sleep(2000);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        /* perform the actions on new window */
        Thread.sleep(2000);
        System.out.println(driver.getTitle());

        /* close the new window if no further actions required */
        Thread.sleep(2000);
        driver.close();

        /* switch back to the original window */
        Thread.sleep(2000);
        driver.switchTo().window(windowHandleBefore);
    }

    //    @Test
//    public void javascriptExecutorClickAndScroll () throws InterruptedException {
//        /* create javascript executor object */
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        /* login to HRM */
//        loginPage.loginToHrm("yoll-student", "Bootcamp1#", driver);
//        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
//        Assert.assertEquals(welcomeMessage,"Welcome Yoll");
//
//        /* click PIM tab */
//        Thread.sleep(2000);
//        WebElement pimTab = driver.findElement(By.id("menu_pim_viewPimModule"));
//        pimTab.click();
//
//        /* call executeAsyncScript() and executeScript() methods to wait for 5 seconds and to click a webelement */
//        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
//        WebElement employeeList = driver.findElement(By.id("menu_pim_viewEmployeeList"));
//        js.executeScript("arguments[0].click();", employeeList);
//        Thread.sleep(5000);
//
//        /* scroll to a specific employee that is on the bottom of the screen */
//        WebElement employee = driver.findElement(By.xpath("//*[text()='Caroline Brittany']"));
//        js.executeScript("arguments[0].scrollIntoView(true);" , employee);
//        Thread.sleep(5000);
//    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
