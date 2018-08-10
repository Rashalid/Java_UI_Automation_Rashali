package com.syscolabs.assignment01.login;

import com.syscolabs.assignment01.functions.LoadPage.LoadWebPage;
import com.syscolabs.assignment01.functions.Login.Login;
import com.syscolabs.assignment01.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
        LoadWebPage.loadPage();
        LoadWebPage.verifyInvalidAge();
        LoadWebPage.verifyValidAge();
    }

    @Test(priority = 1, alwaysRun = true)
    public static void testClickOnMyAccount() {
        SoftAssert softAssert = new SoftAssert();
        Login.testClickOnMyAccount();
        softAssert.assertEquals(Login.isLoginButtonPresent(),"LOGIN","Expected page not found");
        softAssert.assertAll();
    }

    @Test(priority = 2, alwaysRun = true)
    public static void testLoginWithEmptyFields() {
        SoftAssert softAssert = new SoftAssert();
        Login.testClickLoginButton();
        softAssert.assertEquals(Login.getEmptyFieldsError(),"This is a required field.","Expected login details not found");
        softAssert.assertAll();
    }

    @Test(priority = 3, alwaysRun = true)
    public static void testLoginWithCorrectEmailIncorrectPassword() {
        SoftAssert softAssert = new SoftAssert();
        Login.testClickLoginWithCorrectEmailIncorrectPassword();
        softAssert.assertEquals(Login.getIncorrectPasswordError(),"Invalid login or password.","Expected login details not found");
        softAssert.assertAll();
    }

    @Test(priority = 4, alwaysRun = true)
    public static void testLoginWithIncorrectEmailCorrectPassword() {
        SoftAssert softAssert = new SoftAssert();
        Login.testClickLoginWithIncorrectEmailCorrectPassword();
        softAssert.assertEquals(Login.getIncorrectPasswordError(),"Invalid login or password.","Expected login details not found");
        softAssert.assertAll();
    }

    @Test(priority = 5, alwaysRun = true)
    public static void testLoginWithCorrectEmailCorrectPassword(){
        SoftAssert softAssert = new SoftAssert();
        Login.testClickLoginWithCorrectEmailCorrectPassword();
        softAssert.assertEquals(Login.getAccountUserName(),"HELLO, WILLIAM JACOB!","Expected login details not found");
        softAssert.assertAll();
    }

    @AfterClass
    public void closeDriver(){
        LoadWebPage.closeDriver();
    }
}

