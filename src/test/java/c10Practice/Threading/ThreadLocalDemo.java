package c10Practice.Threading;

//import homePage.HomePage;
//import login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
//import utility.Driver;

public class ThreadLocalDemo {

    @BeforeClass(alwaysRun = true)
    public void start(){
        /* Setting path of chrome driver */
        System.out.println("Orange HRM Login Page functionalities verification started");
    }

    @AfterClass(alwaysRun = true)
    public void end(){
        System.out.println("Orange HRM Login Page functionalities verification finished");
    }

    @Parameters("browserName")
    @BeforeMethod(alwaysRun = true)
    public void setup(String browser) throws InterruptedException {
        System.out.println("browser was" + browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        System.out.println("Test is getting executed");
    }

//    @Test(invocationCount = 3, threadPoolSize = 3)
//    public void ohrm() throws InterruptedException {
//        System.out.println("Thread id = " + Thread.currentThread().getId());
//        System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getDriver().hashCode());
//        LocalDriverManager.getDriver().get("http://dev-hrm.yoll.io/");
//        Thread.sleep(2000);
//        LoginPage loginPage = new LoginPage(LocalDriverManager.getDriver());
//        HomePage homePage = new HomePage(LocalDriverManager.getDriver());
//
//        loginPage.login("yoll-student", "Bootcamp5#");
//
//        /* get text of username from homePage and verify */
//        String actualUsernameInHomePage = homePage.usernameinHomePage.getText();
//
//        Assert.assertEquals(actualUsernameInHomePage, "Welcome Yoll", "The username in home page verification failed!!!");
//
//    }

    @Test
    public void bestBuy() throws InterruptedException {
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getDriver().hashCode());

        LocalDriverManager.getDriver().get("https://www.bestbuy.com");
        Thread.sleep(5000);

        //find logo element and verify if it is displayed
        WebElement logo = LocalDriverManager.getDriver().findElement(By.cssSelector("[data-t='header-primary-logo']"));
        boolean actualIsLogoDisplayed = logo.isDisplayed();
        Assert.assertTrue(actualIsLogoDisplayed, "There is no logo in BestBuy Homepage");
    }
    @Test
    public void amazon() throws InterruptedException {
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getDriver().hashCode());

        LocalDriverManager.getDriver().get("https://www.amazon.com");
        Thread.sleep(8000);

        //find logo element and verify if it is displayed
        WebElement logo = LocalDriverManager.getDriver().findElement(By.id("nav-logo-sprites"));
        boolean actualIsLogoDisplayed = logo.isDisplayed();
        Assert.assertTrue(actualIsLogoDisplayed, "There is no logo in Amazon Homepage");
    }
}
