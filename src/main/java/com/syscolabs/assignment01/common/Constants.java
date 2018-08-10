package com.syscolabs.assignment01.common;

public class Constants{

    private Constants (){}

    public static final boolean UPDATE_DASHBOARD = Boolean.parseBoolean(System.getProperty("update.dashboard", "false"));
    public static final boolean RUN_LOCALLY = Boolean.parseBoolean(System.getProperty("run.locally", "true"));

    public static final String TEST_ENV = System.getProperty("test.env", "QA");
    public static final String TEST_RELEASE = System.getProperty("test.release", "Assignment_Rashali");
    public static final String TEST_PROJECT = System.getProperty("test.project", "Java Based Web UI Automation");


    public static final String BROWSER_TYPE = System.getProperty("browser.type", "chrome");
    public static final String RUN_HEADLESS = System.getProperty("run.headless", "false");
    public static final String BROWSER_FIREFOX = "firefox";
    public static final String GOOGLE_URL = System.getProperty("url", " https://www.bundabergrum.com.au ");
    public static final String BROWSER_IE = "internet explorer";
    public static final String EMAIL_ADDRESS = "williamjacob802@gmail.com" ;
    public static final String INVALID_PASSWORD = "123456";
    public static final String INVALID_EMAIL_ADDRESS = "abc123@mail.com";
    public static final String PASSWORD = "12345678";
    public static final String LAST_NAME = "jacob";
    public static final String CREDIT_CARD_NUMBER = "4859671549325864";
}
