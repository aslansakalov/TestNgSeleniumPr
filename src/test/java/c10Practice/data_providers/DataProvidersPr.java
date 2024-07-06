package c10Practice.data_providers;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersPr {

    @DataProvider(name="inputs")
    public Object[][] getData() {
        return new Object[][]{
                {"apple", "MacBook"},
                {"microsoft", "SurfaceBook"},
                {"razer", "RazerBook"},
                {"asus", "ZenBook"},

        };
    }


    @Test(dataProvider="inputs")
    public void testMethod1(String input1, String input2) {
        System.out.println("Input 1 from method1: " + input1);
        System.out.println("Input 2 from method1: " + input2);
    }


 //   @Test(dataProvider="inputs",dataProviderClass =TestData.class)
    public void testMethod2(String input1, String input2) {
        System.out.println("Input 1 from method2: " + input1);
        System.out.println("Input 2 from method2: " + input2);

    }
}

