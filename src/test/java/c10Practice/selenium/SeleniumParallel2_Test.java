package c10Practice.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumParallel2_Test {


    public WebDriver driver=null;

    @BeforeClass
    @Parameters({"browser"})
    public void prepareTest(String browser){

        driver=BrowserFactory.creatInstance(browser);
        DriverFactory.getInstance().setDriver(driver);
        driver=DriverFactory.getInstance().getDriver();

    }
    @Test
    @Parameters({"name","lastName","email","company","jobTitle"})
    void parallelM(String name,String lastName,String email,String company, String jobTitle) throws InterruptedException {
        driver.get("https://www.mabl.com/test-automation-trial?utm_source=capterra&utm_medium=display&utm_campaign=automated-testing");


        WebElement e1=driver.findElement(By.cssSelector("#firstname-0da7d931-032b-4e91-a7f9-963115012c90"));
        e1.sendKeys(name);
        Thread.sleep(1000);


        WebElement e2=driver.findElement(By.cssSelector("#lastname-0da7d931-032b-4e91-a7f9-963115012c90"));
        Thread.sleep(1000);
        e2.sendKeys(lastName);


        WebElement e3=driver.findElement(By.xpath("//*[@id=\"email-0da7d931-032b-4e91-a7f9-963115012c90\"]"));
        Thread.sleep(1000);
        e3.sendKeys(email);


        WebElement e4=driver.findElement(By.xpath("//*[@id=\"company-0da7d931-032b-4e91-a7f9-963115012c90\"]"));
        Thread.sleep(1000);
        e4.sendKeys(company);


//        WebElement e5=driver.findElement(By.xpath("//*[@id=\"jobtitle-0da7d931-032b-4e91-a7f9-963115012c90\"]"));
//        Thread.sleep(1000);
//        e5.sendKeys(jobTitle);

        System.out.println("Print Thread Name: "+Thread.currentThread().getName());
    }

    @AfterClass
    void endTest() throws InterruptedException {
        Thread.sleep(8000);
       DriverFactory.getInstance().removeDriver();
    }


    }

