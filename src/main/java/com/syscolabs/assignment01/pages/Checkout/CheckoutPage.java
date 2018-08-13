package com.syscolabs.assignment01.pages.Checkout;

import com.syscolabs.assignment01.pages.LoadPage.LoadPage;
import org.openqa.selenium.By;

public class CheckoutPage extends LoadPage {

    private By btnCheckout = By.xpath("//span/span[.='Checkout']");
    private By btnProceedToCheckout = By.xpath("//div[@id='price-total-content']//ul[@class='checkout-types']//button[@title='Proceed to Checkout']");
    private By txtCheckoutTitle = By.xpath("//div[1]/h1");
    private By txtCheckoutFirstName = By.xpath("//*[@id=\"billing:firstname\"]");
    private By txtCheckoutLastName = By.xpath("//*[@id=\"billing:lastname\"]");
    private By btnContinue = By.xpath("//*[@id=\"delivery-address-button\"]");
    private By txtCheckoutWithoutMandatoryFieldsError = By.xpath("//*[@id=\"advice-required-entry-billing:lastname\"]");
    private By txtDeliveryOption = By.xpath("//*[@id=\"opc-shipping_method\"]/div[1]/h2");
    private By btnDeliveryContinue = By.xpath("/html//button[@id='shipping-method-button']");
    private By txtPaymentOption = By.xpath("//*[@id=\"opc-payment\"]/div[1]/h2");
    private By radioBtnCreditCard = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div[1]/dt/label");
    private By txtCreditCardField = By.xpath("//*[@id=\"payment_form_braintree\"]/li[3]/label");
    private By txtCreditCardInputField = By.xpath("//input[@id='braintree_cc_number']");
    private By btnPurchase = By.xpath("//*[@id=\"payment-method-button\"]");
    private By txtCreditCardNumberEmptyError = By.xpath("//*[@id=\"advice-required-entry-braintree_cc_number\"]");

    public void clickCheckoutFromCart() {
        loadUI.click(btnCheckout);
    }

    public void clickProceedToCheckout() {
        loadUI.click(btnProceedToCheckout);
    }

    public String isCheckoutPage() {
        return loadUI.getText(txtCheckoutTitle);
    }

    public String verifyFirstName() {
        loadUI.sleep(2);
        return loadUI.getText(txtCheckoutFirstName);
    }

    public String verifyLastName() {
        loadUI.sleep(2);
        return loadUI.getText(txtCheckoutLastName);
    }

    public void deleteMandatoryFieldText() {
        loadUI.click(txtCheckoutLastName);
        loadUI.clear(txtCheckoutLastName);
    }

    public void clickContinueButton() {
        loadUI.click(btnContinue);
    }

    public String checkoutWithoutMandatoryFieldsError() {
        return loadUI.getText(txtCheckoutWithoutMandatoryFieldsError);
    }

    public String isDeliveryOption() {
        return loadUI.getText(txtDeliveryOption);
    }

    public void clickDeliveryContinueButton() {
        loadUI.sleep(2);
        loadUI.click(btnDeliveryContinue);
    }

    public String isPaymentOption() {
        return loadUI.getText(txtPaymentOption);
    }

    public void clickCreditCardRadioButton() {
        loadUI.sleep(2);
        loadUI.click(radioBtnCreditCard);
    }

    public String isCreditCardOption() {
        return loadUI.getText(txtCreditCardField);
    }

    public void enterValues(String lastName) {
        loadUI.click(txtCheckoutLastName);
        loadUI.sendKeys(txtCheckoutLastName, lastName);
        loadUI.sleep(2);
    }

    public void validateCreditCardFields(String creditCardNumber) {
        loadUI.sleep(2);
        loadUI.click(txtCreditCardInputField);
        loadUI.sleep(2);
        loadUI.sendKeys(txtCreditCardInputField, creditCardNumber);
    }

    public void clickPurchaseButton() {
        loadUI.click(btnPurchase);
    }

    public String creditCardEmptyFieldsError() {
        return loadUI.getText(txtCreditCardNumberEmptyError);
    }
}
