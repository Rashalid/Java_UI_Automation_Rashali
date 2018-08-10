package com.syscolabs.assignment01.functions.Checkout;

import com.syscolabs.assignment01.common.Constants;
import com.syscolabs.assignment01.pages.Checkout.CheckoutPage;

public class Checkout {
    private static CheckoutPage checkoutPage = new CheckoutPage();

    public static void clickCheckoutFromCart() {
        checkoutPage.clickCheckoutFromCart();
    }

    public static void clickProceedToCheckout() {
        checkoutPage.clickProceedToCheckout();
    }

    public static String isCheckoutPage() {
        return checkoutPage.isCheckoutPage();
    }

    public static String verifyFirstName() {
        return checkoutPage.verifyFirstName();
    }

    public static String verifyLastName() {
        return checkoutPage.verifyLastName();
    }

    public static void deleteMandatoryFieldText() {
        checkoutPage.deleteMandatoryFieldText();
    }

    public static void clickContinueButton() {
        checkoutPage.clickContinueButton();
    }

    public static String checkoutWithoutMandatoryFieldsError() {
        return checkoutPage.checkoutWithoutMandatoryFieldsError();
    }

    public static String isDeliveryOption() {
        return checkoutPage.isDeliveryOption();
    }

    public static void clickDeliveryContinueButton() {
        checkoutPage.clickDeliveryContinueButton();
    }

    public static String isPaymentOption() {
        return checkoutPage.isPaymentOption();
    }

    public static void clickCreditCardRadioButton() {
        checkoutPage.clickCreditCardRadioButton();
    }

    public static String isCreditCardOption() {
        return checkoutPage.isCreditCardOption();
    }

    public static void enterValues() {
        checkoutPage.enterValues(Constants.LAST_NAME);
    }

    public static void validateCreditCardFields() {
        checkoutPage.validateCreditCardFields(Constants.CREDIT_CARD_NUMBER);
    }

    public static void clickPurchaseButton() {
        checkoutPage.clickPurchaseButton();
    }

    public static String creditCardEmptyFieldsError() {
        return checkoutPage.creditCardEmptyFieldsError();
    }
}
