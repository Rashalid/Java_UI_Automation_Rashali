package com.syscolabs.assignment01.utils;

import com.syscolab.qe.core.ui.SyscoLabCapabilityUtil;
import com.syscolabs.assignment01.common.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverEnvironmentSetUpUtil {

    static Logger logger = Logger.getLogger(DriverEnvironmentSetUpUtil.class);
    private DriverEnvironmentSetUpUtil() {

    }

    public static void setToRunLocallyWithBrowser(String driver) {
        String osArchitecture = "os.arch";
        if (driver.equals(BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/firefox_driver/" + System.getProperty (osArchitecture) + "/geckodriver");
            logger.info(System.getProperty("webdriver.firefox.driver"));
        } else if (driver.equals(BrowserType.IE)) {
            System.setProperty("webdriver.ie.driver", "src/main/resources/ie_driver/" + System.getProperty(osArchitecture) + "/IEDriverServer");
            logger.info(System.getProperty("webdriver.ie.driver"));
        } else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_driver/" + System.getProperty(osArchitecture) + "/chromedriver");
            logger.info(System.getProperty("webdriver.chrome.driver"));
        }

    }

    public static Capabilities setToRunRemotely() {
        DesiredCapabilities capabilities;
        capabilities = SyscoLabCapabilityUtil.getPCCapabilities("WIN 10", "");
        capabilities.setBrowserName(String.valueOf(Constants.BROWSER_TYPE));


        return capabilities;
    }
}

