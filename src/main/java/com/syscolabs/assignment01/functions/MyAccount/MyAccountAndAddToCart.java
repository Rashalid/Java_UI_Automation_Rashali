package com.syscolabs.assignment01.functions.MyAccount;

import com.syscolabs.assignment01.pages.MyAccount.MyAccountAndAddToCartPage;

public class MyAccountAndAddToCart {
    private static MyAccountAndAddToCartPage myAccountPage = new MyAccountAndAddToCartPage();

    public static void testClickOnCart() {
        myAccountPage.clickCartButton();
    }

    public static String isCartEmpty() {
        return myAccountPage.isCartEmpty();
    }

    public static void checkCartItems() {
        myAccountPage.clickRemoveCartItems();

    }

    public static void addItemToCart() {
        myAccountPage.addItemToCart();
    }

    public static String getProductName() {
        return myAccountPage.getProductName();
    }

    public static String getProductNameInCart() {
        return myAccountPage.getProductNameInCart();
    }

    public static String getProductPrice() {
        return myAccountPage.getProductPrice();
    }

    public static String getProductPriceInCart() {
        return myAccountPage.getProductPriceInCart();
    }
}
