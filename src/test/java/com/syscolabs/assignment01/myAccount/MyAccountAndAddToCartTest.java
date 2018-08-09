package com.syscolabs.assignment01.myAccount;

import com.syscolabs.assignment01.functions.LoadPage.LoadWebPage;
import com.syscolabs.assignment01.functions.Login.Login;
import com.syscolabs.assignment01.functions.MyAccount.MyAccountAndAddToCart;
import com.syscolabs.assignment01.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyAccountAndAddToCartTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Java Based Web UI Automation");
        LoadWebPage.loadPage();
        LoadWebPage.verifyInvalidAge();
        LoadWebPage.verifyValidAge();
        Login.testClickOnMyAccount();
        Login.testClickLoginWithCorrectEmailCorrectPassword();
    }

    @Test(priority = 1, alwaysRun = true)
    public static void testCartItemsAndRemoveItems() {
        SoftAssert softAssert = new SoftAssert();
        MyAccountAndAddToCart.testClickOnCart();
        MyAccountAndAddToCart.checkCartItems();
        softAssert.assertEquals(MyAccountAndAddToCart.isCartEmpty(),"0","Expected values not found");
        softAssert.assertAll();
    }

    // test to add items
    @Test(priority = 2, alwaysRun = true)
    public static void testToAddItemsToCart() {
        SoftAssert softAssert = new SoftAssert();
        MyAccountAndAddToCart.addItemToCart();
        softAssert.assertEquals(MyAccountAndAddToCart.getProductName(),MyAccountAndAddToCart.getProductNameInCart(),"Expected values not found");
        softAssert.assertEquals(MyAccountAndAddToCart.getProductPrice(),MyAccountAndAddToCart.getProductPriceInCart(),"Expected values not found");
        softAssert.assertAll();
    }

    @AfterClass
    public void closeDriver(){
        LoadWebPage.closeDriver();
    }
}

