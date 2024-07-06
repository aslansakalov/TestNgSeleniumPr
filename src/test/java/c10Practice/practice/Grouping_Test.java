package c10Practice.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Grouping_Test {


    @Test(groups = {"laptops", "apple"})
    public void testMacBook() {
        System.out.println("Running Test - MacBook");
    }

    @Test(groups = {"laptops", "microsoft"})
    public void testSurfaceBook() {
        System.out.println("Running Test - Surface Book");
    }

    @Test(groups = { "desks" })
    public void testYoll() {
        System.out.println("Running Test - Yoll Academy Desk");
    }

    @Test(groups = { "desks" })
    public void testHPEliteOne() {
        System.out.println("Running Test - HP EliteOne");
    }


    @Test(groups = {"phones", "ios"})
    public void testIphone() {
        System.out.println("Running Test - iPhone");
    }

    @Test(groups = {"phones", "android"})
    public void testSamsungNote() {
        Assert.assertTrue(true);
        System.out.println("Running Test - Samsung Galaxy Note");
    }
}
