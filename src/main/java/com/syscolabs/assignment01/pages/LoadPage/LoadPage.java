package com.syscolabs.assignment01.pages.LoadPage;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import com.syscolabs.assignment01.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LoadPage {
    protected static SyscoLabUI loadUI;

    private By txtWebPageTitle = By.xpath("//*[@id=\"age_content\"]/form/div[7]/div/span");
    private By ddBirthYear = By.xpath("//*[@id=\"age_select_year\"]");
    private By txtInvalidBirthdayMessage = By.xpath("//*[@id=\"age_missing_message\"]/span");
    private By ddSelectDate = By.xpath("//*[@id=\"age_select_day\"]");
    private By ddSelectMonth = By.xpath("//*[@id=\"age_select_month\"]");
    private By btnEnter = By.xpath("//*[@id=\"age_confirm_btn\"]");
    private By txtMyAccount = By.xpath("//*[@id=\"quick-access-list\"]/li[1]/ul/li[2]/ul/li/a");

    public void loadWebPage(Capabilities capabilities) {
        ChromeOptions chromeOptions = new ChromeOptions();

        if(Constants.RUN_HEADLESS.equals("true"))
            chromeOptions.addArguments("--headless");

        if(Constants.BROWSER_TYPE.equals(Constants.BROWSER_FIREFOX))
            loadUI = new SyscoLabWUI(capabilities, "FIREFOX");
        else if(Constants.BROWSER_TYPE.equals(Constants.BROWSER_IE))
            loadUI = new SyscoLabWUI(capabilities, "IE");
        else
            loadUI = new SyscoLabWUI(capabilities,chromeOptions);


        loadUI.navigateTo(Constants.GOOGLE_URL);
        loadUI.driver.manage().window().maximize();
        loadUI.sleep(2);
    }

    public String checkTitle(){
        loadUI.sleep(2);
        return loadUI.getText(txtWebPageTitle);
    }

    public void selectInvalidBirthYear() {
        loadUI.sleep(2);
        loadUI.click(ddSelectDate);

        try {
            Robot robot = new Robot();
            for (int i = 1; i <= 2; i++) {
                robot.delay(1000);
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
            }
            robot.keyPress(KeyEvent.VK_ENTER);
            loadUI.sleep(1);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(2000);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        loadUI.sleep(2);
        loadUI.click(ddSelectMonth);

        try {
            Robot robot = new Robot();
            for (int i = 1; i <= 2; i++) {
                robot.delay(1000);
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
            }
            robot.keyPress(KeyEvent.VK_ENTER);
            loadUI.sleep(1);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(2000);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        loadUI.sleep(2);
        loadUI.click(ddBirthYear);

        try {
            Robot robot = new Robot();
            for (int i = 1; i <= 10; i++) {
                robot.delay(1000);
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
            }
            robot.keyPress(KeyEvent.VK_ENTER);
            loadUI.sleep(1);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(2000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        loadUI.sleep(2);
        loadUI.click(btnEnter);
    }

    public void closeDriver() {
        if (loadUI.driver != null)
            loadUI.quit();
    }

    public String checkInvalidBirthdayMessage() {
        loadUI.sleep(2);
        return loadUI.getText(txtInvalidBirthdayMessage);
    }

    public void selectValidBirthYear() {
        loadUI.sleep(2);

        loadUI.click(ddBirthYear);
        loadUI.sleep(2);

        try {
            Robot robot = new Robot();
            for (int i = 1; i <= 1; i++) {
                robot.delay(1000);
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
            }
            robot.keyPress(KeyEvent.VK_ENTER);
            loadUI.sleep(1);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(2000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        loadUI.sleep(2);
        loadUI.click(btnEnter);
        loadUI.sleep(5);
    }

    public String checkMyAccount() {
        loadUI.sleep(2);
        return loadUI.getText(txtMyAccount);
    }
}
