package com.sysco.the_athletes_foot.pages;

import org.openqa.selenium.By;

public class CartPage extends LandingPage{

    private By btnSecureCheckOut = By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[2]/ul/li[1]/button");
    private By lblFullName = By.xpath("/html/body/div[1]/header/div[1]/div[1]/ul/li[2]/span/span");

    public void clickOnSecureCheckOutButton(){
        syscoLabUIOgm.click(btnSecureCheckOut);
    }



    public void waitTillPageLoads(){
        syscoLabUIOgm.waitTillElementLoaded(lblFullName,5000);
    }
}
