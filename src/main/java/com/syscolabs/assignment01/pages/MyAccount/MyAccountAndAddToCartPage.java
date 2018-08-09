package com.syscolabs.assignment01.pages.MyAccount;

import com.syscolabs.assignment01.pages.LoadPage.LoadPage;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MyAccountAndAddToCartPage extends LoadPage {

    private By btnCart = By.xpath("//*[@id=\"cartHeader\"]");
    private By txtCartEmpty = By.xpath("//*[@id=\"quick-access-list\"]/li[2]/ul/li[3]/div/div[1]/span[2]");
    private By btnRemoveCartItems = By.xpath("/html//ol[@id='mini-cart']//a[@title='Remove']");
    private By btnProducts = By.xpath("//*[@id=\"nav-wrapper\"]/div/ul[1]/li[1]/a");
    private By btnClassicRange = By.xpath("//*[@id=\"nav-wrapper\"]/div/div[4]/div[1]/div[1]/ul/li/ul/li[5]/a");
    private By btnFirstItemOnProductPage = By.xpath("//div[@id='recommended-container-block']//div[@role='listbox']/li[2]//a[@id='main-image']/img[@alt='Bundaberg Rum UP 700ml']");
    private By btnAddToCart = By.xpath("//*[@id=\"price-inner-content\"]/div[2]/div/div[2]/button");
    private By txtProductName = By.xpath("//*[@id=\"product-info\"]/div/div[1]/h1");
    private By txtProductNameInCart = By.xpath("//*[@id=\"mini-cart\"]/li/div/p/a");
    private By txtProductPrice = By.xpath("//div[@id='price-inner-content']//span[@class='regular-price']/span[@class='price']");
    private By txtProductPriceInCart = By.xpath("/html//ol[@id='mini-cart']/li[@class='item odd']//table//span[@class='price']");
    private By txtEmptyCartError= By.xpath("//*[@id=\"topCartContent\"]/div/p[2]");

    public void clickCartButton() {
        loadUI.sleep(2);
        loadUI.click(btnCart);
        loadUI.sleep(2);
    }

    public String isCartEmpty() {
        loadUI.sleep(2);
        return loadUI.getText(txtCartEmpty);
    }

//    public void clickRemoveCartItems() {
//        loadUI.sleep(2);
//        loadUI.click(btnRemoveCartItems);
//        loadUI.sleep(5);
//        try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_ENTER);
//            loadUI.sleep(1);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//            robot.delay(2000);
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//    }

    public void clickRemoveCartItems() {
        int noOfItems = Integer.parseInt(loadUI.getText(txtCartEmpty));

        if (noOfItems != 0) {
            for (int i = 1; i <= noOfItems; i++) {
                loadUI.driver.findElement(btnCart).click();
                loadUI.sleep(5);
                loadUI.driver.findElement(btnRemoveCartItems).click();
                loadUI.sleep(2);
                try {
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ENTER);
                    loadUI.sleep(1);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                    robot.delay(2000);
                 } catch (AWTException e) {
            e.printStackTrace();
        }

            }
            loadUI.driver.findElement(btnCart).click();
            getEmptyCartError();

        }
    }

    private void getEmptyCartError() {
        loadUI.getText(txtEmptyCartError);
    }

    public void addItemToCart() {
        loadUI.mouseHover(btnProducts);
        loadUI.click(btnClassicRange);
        loadUI.sleep(2);
        loadUI.click(btnFirstItemOnProductPage);
        loadUI.click(btnAddToCart);
        loadUI.sleep(5);
    }

    public String getProductName() {
        return loadUI.getText(txtProductName);
    }

    public String getProductNameInCart() {
        return loadUI.getText(txtProductNameInCart);
    }

    public String getProductPrice() {
        return loadUI.getText(txtProductPrice);
    }

    public String getProductPriceInCart() {
        return loadUI.getText(txtProductPriceInCart);
    }
}