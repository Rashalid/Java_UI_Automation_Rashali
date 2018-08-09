package com.syscolabs.assignment01.loadPage;

import com.syscolabs.assignment01.functions.LoadPage.LoadWebPage;
import com.syscolabs.assignment01.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoadPageTest extends TestBase{

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Java Based Web UI Automation");
    }

    @Test(priority = 1, alwaysRun = true)
    public static void testLoadPage() {

        SoftAssert softAssert = new SoftAssert();
        LoadWebPage.loadPage();
        softAssert.assertEquals(LoadWebPage.checkTitle(),"Enter your birthdate:","Expected title not found");
        softAssert.assertAll();
    }

    @Test(priority = 2, alwaysRun = true)
    public static void testInvalidBirthday() {

        SoftAssert softAssert = new SoftAssert();
        LoadWebPage.verifyInvalidAge();
        softAssert.assertEquals(LoadWebPage.checkInvalidBirthdayMessage(),"Sorry, your age or location does not permit you to enter at this time.","Invalid Birth Year");
        softAssert.assertAll();
    }

    @Test(priority = 3, alwaysRun = true)
    public static void testValidBirthday() {

        SoftAssert softAssert = new SoftAssert();
        LoadWebPage.verifyValidAge();
        softAssert.assertEquals(LoadWebPage.checkMyAccount(),"My Account","Expected page not found");
        softAssert.assertAll();
    }

    @AfterClass
    public void closeDriver(){
        LoadWebPage.closeDriver();
    }
}

