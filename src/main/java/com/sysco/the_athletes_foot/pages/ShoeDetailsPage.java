package com.sysco.the_athletes_foot.pages;

import org.openqa.selenium.By;

public class ShoeDetailsPage extends LandingPage {

    private By lblShoeSize = By.xpath("//*[@id=\"swatch-row-227\"]/div[@class=\"swatch-option text\"][1]");
    private By lblAddToCart = By.xpath("//*[@id=\"product-addtocart-button\"]");
    private By lblUserName = By.xpath("/html/body/div[1]/header/div[1]/div[1]/ul/li[2]/span/span");
    private By lblShoeSizeMetrics = By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div/div[1]/div[1]/span[1]");
    private By lblUSMensMetric = By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div/div[1]/div[2]/a[4]");
    private By lblShoeName = By.xpath("//*[@id=\"maincontent\"]/div/div/div[1]/div[2]/div/div[1]/div[1]/div/h1/span");

    public void selectShoeSize(){
        syscoLabUIOgm.click(lblShoeSize);
    }

    public void clickOnAddToCartButton() {
        syscoLabUIOgm.click(lblAddToCart);
    }

    public void clickOnShoeSizeMetrics(){
        syscoLabUIOgm.click(lblShoeSizeMetrics);
    }

    public void clickOnUSMensMetric(){
        syscoLabUIOgm.click(lblUSMensMetric);
    }

    public void clickOnShoeNameLbl(){
        syscoLabUIOgm.moveToAndClick(lblShoeName);
    }

    public void waitTillPageLoads(){
        syscoLabUIOgm.waitTillElementLoaded(lblUserName,5000);
    }
}
