package c11Practice.dataProviders.com.theinternetHeroku;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "statusCodes")
    public Object[][] getStatusCodes(){
        return new Object[][]{
                {"200", "This page returned a 200 status code."},
                {"301", "This page returned a 301 status code."},
                {"404", "This page returned a 404 status code."},
                {"500", "This page returned a 500 status code."}
        };
    }
}
