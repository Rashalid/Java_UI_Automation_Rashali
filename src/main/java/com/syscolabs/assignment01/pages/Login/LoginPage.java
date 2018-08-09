package com.syscolabs.assignment01.pages.Login;

import com.syscolabs.assignment01.pages.LoadPage.LoadPage;
import org.openqa.selenium.By;

public class LoginPage extends LoadPage {

    private By btnMyAccount = By.xpath("//*[@id=\"quick-access-list\"]/li[1]/ul/li[2]/ul/li/a");
    private By btnLogin = By.xpath("//*[@id=\"send2\"]/span/span");
    private By txtEmptyFieldsError = By.xpath("//*[@id=\"advice-required-entry-email\"]");
    private By txtEmail = By.xpath("//*[@id=\"email\"]");
    private By txtPassword = By.xpath("//*[@id=\"pass\"]");
    private By txtIncorrectLoginError = By.xpath("/html/body/div[3]/div[3]/div[2]/div/div/ul/li/ul/li/span");
    private By txtAccountUserName = By.xpath("//div/div[3]/div[1]/h2");


    public void clickMyAccount() {
        loadUI.sleep(2);
        loadUI.click(btnMyAccount);
        loadUI.sleep(2);
    }

    public String isLoginButtonPresent() {
        return loadUI.getText(btnLogin);
    }

    public void clickLoginButton() {
        loadUI.click(btnLogin);
        loadUI.sleep(2);
    }

    public String getEmptyFieldsError() {
        return loadUI.getText(txtEmptyFieldsError);
    }

    public void clickLoginWithCorrectEmail(String validEmail) {
        loadUI.click(txtEmail);
        loadUI.sendKeys(txtEmail, validEmail);
        loadUI.sleep(2);
    }

    public void clickLoginWithIncorrectEmail(String validEmail) {
        loadUI.click(txtEmail);
        loadUI.sendKeys(txtEmail, validEmail);
        loadUI.sleep(2);
    }

    public void clickLoginWithCorrectPassword(String invalidPassword) {
        loadUI.click(txtPassword);
        loadUI.sendKeys(txtPassword, invalidPassword);
        loadUI.sleep(2);
        loadUI.click(btnLogin);
    }

    public void clickLoginWithIncorrectPassword(String invalidPassword) {
        loadUI.click(txtPassword);
        loadUI.sendKeys(txtPassword, invalidPassword);
        loadUI.sleep(2);
        loadUI.click(btnLogin);
    }

    public String getIncorrectLoginError() {
        return loadUI.getText(txtIncorrectLoginError);
    }

    public String getAccountUserName() {
        return loadUI.getText(txtAccountUserName);
    }
}
