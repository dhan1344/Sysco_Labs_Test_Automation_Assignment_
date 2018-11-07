package com.sysco.the_athletes_foot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends LandingPage{
    private By lnkLogin = By.xpath("//a[@class=\"link\"]");
    private By btnLogin = By.id("send2");
    private By txtEmail = By.id("email");
    private By txtPassword = By.id("pass");
    private By txtFullNameOfUser = By.xpath("/html/body/div[2]/header/div[1]/div[1]/ul/li[2]/span/span");

    public void navigateToLoginPage(){
        syscoLabUIOgm.waitTillElementLoaded(lnkLogin,5000);
        syscoLabUIOgm.click(lnkLogin);
    }

    public boolean isUserNameDisplayed(){
        return syscoLabUIOgm.isDisplayed(txtFullNameOfUser);
    }

    public String getUserName(){
        return syscoLabUIOgm.getText(txtFullNameOfUser);
    }

    public void waitforUserNameToLoad(){
        syscoLabUIOgm.waitTillElementLoaded(txtFullNameOfUser,5000);
    }


    public boolean isLoginButtonDisplayed(){
        return syscoLabUIOgm.isDisplayed(btnLogin);
    }

    public void waitForPageToLoad(){
        syscoLabUIOgm.waitTillElementLoaded(btnLogin,5000);
    }

    public void enterEmail(String email){
        syscoLabUIOgm.sendKeys(txtEmail,email);
    }

    public void enterPassword(String password){
        syscoLabUIOgm.sendKeys(txtPassword,password);
    }

    public void clickLogin(){
        syscoLabUIOgm.click(btnLogin);
    }

}
