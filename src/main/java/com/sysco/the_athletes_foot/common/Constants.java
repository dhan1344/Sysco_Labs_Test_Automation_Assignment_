package com.sysco.the_athletes_foot.common;

public class Constants {
    public static final String TEST_ENV = System.getProperty("test.env", "QA");
    public static final String TEST_RELEASE = System.getProperty("test.release", "1.0.0");
    public static final String TEST_PROJECT = System.getProperty("test.project", "Java Based Web UI Automation");
    public static final boolean UPDATE_DASHBOARD = Boolean.parseBoolean(System.getProperty("update.dashboard", "false"));
    public static final boolean RUN_LOCALLY = Boolean.parseBoolean(System.getProperty("run.locally", "true"));
    public static final String APP_URL = System.getProperty("app.url", "https://www.theathletesfoot.com.au/");
    public static final String APP_OS = System.getProperty("app.os", "WIN10");
    public static final String APP_BROWSER = System.getProperty("app.browser", "chrome");


}