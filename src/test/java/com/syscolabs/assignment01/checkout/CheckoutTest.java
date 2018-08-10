package com.syscolabs.assignment01.checkout;

import com.syscolabs.assignment01.functions.Checkout.Checkout;
import com.syscolabs.assignment01.functions.LoadPage.LoadWebPage;
import com.syscolabs.assignment01.functions.Login.Login;
import com.syscolabs.assignment01.functions.MyAccount.MyAccountAndAddToCart;
import com.syscolabs.assignment01.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
        LoadWebPage.loadPage();
        LoadWebPage.verifyInvalidAge();
        LoadWebPage.verifyValidAge();
        Login.testClickOnMyAccount();
        Login.testClickLoginWithCorrectEmailCorrectPassword();
        MyAccountAndAddToCart.testClickOnCart();
        MyAccountAndAddToCart.checkCartItems();
        MyAccountAndAddToCart.addItemToCart();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
    }

    @Test(priority = 1, alwaysRun = true)
    public static void testCheckout() {
        SoftAssert softAssert = new SoftAssert();
        Checkout.clickCheckoutFromCart();
        Checkout.clickProceedToCheckout();
        softAssert.assertEquals(Checkout.isCheckoutPage(),"CHECKOUT","Expected page not found");
        softAssert.assertAll();
    }

    @Test(priority = 2, alwaysRun = true)
    public static void testVerifyFirstNameLastName() {
        SoftAssert softAssert = new SoftAssert();
//        Checkout.verifyFirstName();
        softAssert.assertEquals(Checkout.verifyFirstName(),"william","Expected values not found");
//        Checkout.verifyLastName();
        softAssert.assertEquals(Checkout.verifyLastName(),"jacob","Expected values not found");
        softAssert.assertAll();
    }

    @Test(priority = 3, alwaysRun = true)
    public static void testValidateContinueButtonWithoutFillingMandatoryFields() {
        SoftAssert softAssert = new SoftAssert();
        Checkout.deleteMandatoryFieldText();
        Checkout.clickContinueButton();
        softAssert.assertEquals(Checkout.checkoutWithoutMandatoryFieldsError(),"This is a required field.","Expected values not found");
        Checkout.enterValues();
        softAssert.assertAll();
    }

    @Test(priority = 4, alwaysRun = true)
    public static void testBillingAndShippingContinueButton() {
        SoftAssert softAssert = new SoftAssert();
        Checkout.clickContinueButton();
        softAssert.assertEquals(Checkout.isDeliveryOption(),"DELIVERY OPTIONS","Expected option not found");
        softAssert.assertAll();
    }

    @Test(priority = 5, alwaysRun = true)
    public static void testDeliveryContinueButton() {
        SoftAssert softAssert = new SoftAssert();
        Checkout.clickDeliveryContinueButton();
        softAssert.assertEquals(Checkout.isPaymentOption(),"PAYMENT INFO","Expected option not found");
        softAssert.assertAll();
    }

    @Test(priority = 6, alwaysRun = true)
    public static void testSelectPaymentTypeCC() {
        SoftAssert softAssert = new SoftAssert();
        Checkout.clickCreditCardRadioButton();
        softAssert.assertEquals(Checkout.isCreditCardOption(),"Credit Card Number*","Expected option not found");
        softAssert.assertAll();
    }

    @Test(priority = 7, alwaysRun = true)
    public static void testPurchaseButtonWithEmpyFields() {
        SoftAssert softAssert = new SoftAssert();
        Checkout.clickPurchaseButton();
        softAssert.assertEquals(Checkout.creditCardEmptyFieldsError(),"This is a required field.","Expected values not found");
        softAssert.assertAll();
    }

    @Test(priority = 8, alwaysRun = true)
    public static void testValidateCCFields() {
        SoftAssert softAssert = new SoftAssert();
        Checkout.validateCreditCardFields();
        Checkout.clickPurchaseButton();
        softAssert.assertEquals(Checkout.creditCardEmptyFieldsError(),"Please enter a valid credit card number.","Expected option not found");
        softAssert.assertAll();
    }

    @AfterClass
    public void closeDriver(){
        LoadWebPage.closeDriver();
    }
}
