package c11Practice.annotations;


import org.testng.annotations.*;

public class BasicAnnotations {

    @BeforeMethod
    public void login(){
        System.out.println("    Create Webdriver object");
        System.out.println("    Login to the application");
        System.out.println("    Go to the homepage");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("    Log out from application");
        System.out.println("    close the driver");
    }


    @BeforeClass
    public void start(){
        System.out.println("This runs once before any method in the class");
    }

    @AfterClass
    public void stop(){
        System.out.println("This runs once after all the methods in the class");
    }

    @Test(priority = 1)
    public void search(){
        System.out.println("        Verify search with keyword");
    }

    @Test(priority = 2)
    public void advancedSearch(){
        System.out.println("        Verify Advanced Search functionality");
    }

    @Test(priority = 3)
    public void addProject(){
        System.out.println("        Verify Adding new project");
    }

}
