package com.sysco.the_athletes_foot.functions;

import com.sysco.the_athletes_foot.common.Constants;
import com.sysco.the_athletes_foot.pages.LandingPage;
import com.sysco.the_athletes_foot.pages.LoginPage;
import com.sysco.the_athletes_foot.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class Login  {

    public static LandingPage landingPage = new LandingPage();
    public static LoginPage loginPage = new LoginPage();



    public static void navigateToLoginPage(){
        loginPage.navigateToLoginPage();
    }

    public static boolean isLoginPageDisplayed(){
        return loginPage.isLoginButtonDisplayed();
    }

    public static boolean isUserNameDisplayed(){ return loginPage.isUserNameDisplayed();}

    public static void waitTillLoginPageLoads(){
        loginPage.waitForPageToLoad();
    }

    public static void waitTillUserNameLoads(){ loginPage.waitforUserNameToLoad();}

    public static void login(String email,String password){
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }



    public static String getFullNameOfUser(){
        return loginPage.getUserName();
    }

    public static void quiteDriver() {
        landingPage.quitDriver();
    }


}
