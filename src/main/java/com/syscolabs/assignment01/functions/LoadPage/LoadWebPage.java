package com.syscolabs.assignment01.functions.LoadPage;

import com.syscolabs.assignment01.common.Constants;
import com.syscolabs.assignment01.pages.LoadPage.LoadPage;
import com.syscolabs.assignment01.utils.DriverEnvironmentSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LoadWebPage {
    private static LoadPage loadWebPage = new LoadPage();

    private LoadWebPage() {
    }

    public static void loadPage() {
        if (Constants.RUN_LOCALLY) {
            DriverEnvironmentSetUpUtil.setToRunLocallyWithBrowser(Constants.BROWSER_TYPE);
            DesiredCapabilities capabilities = null;
            loadWebPage.loadWebPage(capabilities);
        } else {
            loadWebPage.loadWebPage(DriverEnvironmentSetUpUtil.setToRunRemotely());
        }
    }

    public static String checkTitle(){
        return loadWebPage.checkTitle();
    }

    public static void verifyInvalidAge(){
        loadWebPage.selectInvalidBirthYear();
    }

    public static String checkInvalidBirthdayMessage() {
        return loadWebPage.checkInvalidBirthdayMessage();
    }

    public static void closeDriver(){
        loadWebPage.closeDriver();
    }

    public static void verifyValidAge() {
        loadWebPage.selectValidBirthYear();
    }

    public static String checkMyAccount() {
        return loadWebPage.checkMyAccount();
    }
}
