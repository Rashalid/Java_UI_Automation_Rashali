package com.syscolabs.assignment01.functions.Login;

import com.syscolabs.assignment01.common.Constants;
import com.syscolabs.assignment01.pages.Login.LoginPage;

public class Login {
    private static LoginPage loginPage = new LoginPage();

    private Login() {
    }

    public static void testClickOnMyAccount() {
        loginPage.clickMyAccount();
    }

    public static String isLoginButtonPresent() {
        return loginPage.isLoginButtonPresent();
    }

    public static void testClickLoginButton() {
        loginPage.clickLoginButton();
    }

    public static String getEmptyFieldsError() {
        return loginPage.getEmptyFieldsError();
    }

    public static void testClickLoginWithCorrectEmailIncorrectPassword() {
        loginPage.clickLoginWithCorrectEmail(Constants.EMAIL_ADDRESS);
        loginPage.clickLoginWithIncorrectPassword(Constants.INVALID_PASSWORD);
    }

    public static String getIncorrectPasswordError() {
        return loginPage.getIncorrectLoginError();
    }

    public static void testClickLoginWithIncorrectEmailCorrectPassword() {
        loginPage.clickLoginWithIncorrectEmail(Constants.INVALID_EMAIL_ADDRESS);
        loginPage.clickLoginWithCorrectPassword(Constants.PASSWORD);
    }

    public static void testClickLoginWithCorrectEmailCorrectPassword() {
        loginPage.clickLoginWithCorrectEmail(Constants.EMAIL_ADDRESS);
        loginPage.clickLoginWithCorrectPassword(Constants.PASSWORD);
    }

    public static String getAccountUserName() {
        return loginPage.getAccountUserName();
    }

}
