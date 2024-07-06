package c11Practice.assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsPracticeTest {


        @Test
        public void verifyBasicStuff(){

                boolean expectedLogoDisplayed = false;  // this is coming from requirement

                boolean actualLogoDisplayed = true;  // we are getting this value from UI

//                Assert.assertTrue(actualLogoDisplayed, "The validation of logo displayed is failed!!!");

//                Assert.assertFalse(actualLogoDisplayed, "The logo validation is failed!!!!");

                String expectedTitle = "Welcome Yoll student";
                String actualTitle = "welcome yoll"; // this is the result of selenium statement  ex: driver.getTitle()

                Assert.assertNotEquals(actualTitle, expectedTitle, "Title verification is failed!!!");
                System.out.println("Hello World");

                String expect = "";
                String str = null;

                Assert.assertNotNull(str);


            // verify numbers
            // verify 2 string equality
            // verify two object
            //verify boolean
        }

        @Test
        public void verifyMoreBasicStuff(){



            // verify not equality
            // verify null concept
        }

}
