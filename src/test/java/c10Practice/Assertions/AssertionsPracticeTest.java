package c10Practice.Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPracticeTest {

        String webdriverAddress = "webdriver.chrome.driver";
        String webdriverPath = "src/main/resources/chromedriver";
        WebDriver driver;

        @BeforeMethod
        public void setup(){
            //Setup our webdriver
            System.setProperty(webdriverAddress, webdriverPath);
            driver = new ChromeDriver();
        }

    @Test
    public void assertTrue() {
        // if you are trying to assert true
        // your expected is true;
        boolean expected = true;
        boolean actualValue = 5<3;

        Assert.assertTrue(actualValue, "Are you kidding me?");
//        Assert.assertEquals(actualValue,expected, "Are you kidding me?" );

    }

    @Test
    public void assertFalse(){
        // if my expectation is false
        boolean expectedValue = false;
        boolean actualValue = 6 > 10;  //false

        Assert.assertFalse(actualValue, "Test case failed!!! This is simple math!!!" );
    }

        @Test
        public void verifyBasicStuff(){
                Assert.assertTrue((10/0)<4, "Are you kidding me? Of course this is not true");
        }

        @Test
        public void verifyMoreBasicStuff(){
                Assert.assertFalse(11==10, "Hmmmm");
        }

        @Test
        public void verifyLogo() throws InterruptedException {
                driver.get("https://www.amazon.com");
                Thread.sleep(2000);
                Assert.assertTrue(driver.findElement(By.cssSelector("[class='nav-logo-link']")).isDisplayed(), "Amazon Logo is not displayed");
                driver.quit();
        }


        @Test
        public void verifyCity() throws InterruptedException {

                driver.get("https://www.amazon.com");
                Thread.sleep(2000);
                WebElement city = driver.findElement(By.id("glow-ingress-line2"));
                String expectedCityName = "Select your address";
                String actualCityName = city.getText();
                Assert.assertEquals(actualCityName, expectedCityName);
                driver.quit();
        }


        @Test
        public void verifyFbTitle(){
                driver.get("https://www.facebook.com");
                String expectedTitle = "Facebook - Log In or Sign Up";
                String actualTitle = driver.getTitle();
                Assert.assertEquals(actualTitle,expectedTitle);
                driver.close();
        }


       @Test
        public void listViewTest() throws InterruptedException {
               driver.get("http://automationpractice.com/");
               driver.manage().window().maximize();
               Thread.sleep(2000);
               //locate search inputbox
               WebElement searchInputBox = driver.findElement(By.id("search_query_top"));
               //Search for tshirt and Press enter
               searchInputBox.sendKeys("T-shirt"+ Keys.ENTER);
               Thread.sleep(2000);
               //Locate list element
               WebElement listViewBtn = driver.findElement(By.id("list"));

               //Check weather this element is not selected
               Assert.assertNotEquals(listViewBtn.getAttribute("class"), "selected");
               Thread.sleep(1000);
               listViewBtn.click();
               Thread.sleep(1000);
               //Now check weather list element is selected
               Assert.assertEquals(listViewBtn.getAttribute("class"), "selected");
               driver.close();
       }


        public void nullTest() throws InterruptedException {
            driver.get("https://demos.jquerymobile.com/1.4.3/forms-disabled/");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            WebElement inputBox = driver.findElement(By.id("textinput-1"));
            Assert.assertNotNull(inputBox.getAttribute("disabled"));
        }



        public void hardAssertTest(){
            System.out.println("This code is executed before the Assertion");
            Assert.assertEquals("a", "b");

            System.out.println("This code is executed after the Assertion");
        }


        public void softAssertTest(){
            System.out.println("This code is executed before the Assertion");
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals("a", "b");
            softAssert.assertEquals("c", "d");
            System.out.println("This code is executed after the Assertion");

            softAssert.assertAll();
        }
}
