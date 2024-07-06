package c10Practice.selenium;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private DriverFactory(){

    }
    private static DriverFactory instance=new DriverFactory();
    public static DriverFactory getInstance(){
        return instance;
    }

    ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();// thread local driver object for webdriver

    public WebDriver getDriver(){
        return driver.get();
    }
    public  void setDriver(WebDriver driverParameter){
        driver.set(driverParameter);
    }
    public void removeDriver(){
        driver.get().quit();
        driver.remove();
    }
}
