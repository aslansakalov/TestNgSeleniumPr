package c10Practice.Hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HrmJobsTest {
    public static LoginPage loginPage;
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://dev-hrm.yoll.io/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        loginPage = new LoginPage(driver);
        loginPage.loginToHrm("yoll-student", "Bootcamp1#", driver);
        Thread.sleep(1000);
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("menu_admin_Job")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
        Thread.sleep(1000);
    }

    @Test(groups = {"Smoke", "Regression"})
    public void addJobTitle() throws InterruptedException {
        String jobTitle = "Scrum Master " + ThreadLocalRandom.current().nextInt(1,10000);
        WebElement addJobTitleBtn = driver.findElement(By.id("btnAdd"));
        WebElement deleteJobTitleBtn = driver.findElement(By.id("btnDelete"));
        //Verify buttons are displayed
        Assert.assertTrue(addJobTitleBtn.isDisplayed());
        Assert.assertTrue(deleteJobTitleBtn.isDisplayed());
        //Add new Job Title
        addJobTitleBtn.click();
        Thread.sleep(3000);
        WebElement jobTitleInput = driver.findElement(By.id("jobTitle_jobTitle"));
        jobTitleInput.sendKeys(jobTitle);
        WebElement jobTitleDesc = driver.findElement(By.id("jobTitle_jobDescription"));
        jobTitleDesc.sendKeys("Responsible for handling Scrum Team");
        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(3000);
        //Time to verify the new record got added
        List<WebElement> jobTitles = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td/a"));
        boolean result = false;
        for (WebElement eachJob: jobTitles){
            if(eachJob.getText().equals(jobTitle)){
                result=true;
            }
        }
        Assert.assertTrue(result);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
