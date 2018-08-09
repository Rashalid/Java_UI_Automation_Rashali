package com.syscolabs.assignment01.utils;

import com.google.gson.JsonArray;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import com.syscolab.qe.core.reporting.SyscoLabQCenter;
import com.syscolab.qe.core.reporting.SyscoLabReporting;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolabs.assignment01.common.Constants;
import com.syscolabs.assignment01.functions.LoadPage.LoadWebPage;
import com.syscolabs.assignment01.common.Constants;
import com.syscolabs.assignment01.functions.Login.Login;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(SyscoLabListener.class)
public class TestBase extends SyscoLabListener {
    private SyscoLabListener testListeners;
    private SyscoLabQCenter syscoLabQCenter;
    protected SyscoLabUI loadPage;

    static JsonArray elements;

    static JsonArray skippedTests;
    long testSuiteStarted = 0;
    long testSuiteDuration = 0;
    private int skipCount = 0;

    @BeforeTest
    public void init() {

        testListeners = new SyscoLabListener();
        syscoLabQCenter = new SyscoLabQCenter();

        DesiredCapabilities capabilities1 = null;
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Test Running " + this.getClass().toString());
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp(ITestContext iTestContext) {
        try {
            syscoLabQCenter.setProjectName(Constants.TEST_PROJECT);
            syscoLabQCenter.setEnvironment(Constants.TEST_ENV);

            syscoLabQCenter.setRelease(Constants.TEST_RELEASE);
            syscoLabQCenter.setModule(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setFeature(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setClassName(iTestContext.getClass().getName());

            if (Constants.UPDATE_DASHBOARD)
                SyscoLabReporting.generateJsonFile(testListeners.getResults(), syscoLabQCenter);

            LoadWebPage.closeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

