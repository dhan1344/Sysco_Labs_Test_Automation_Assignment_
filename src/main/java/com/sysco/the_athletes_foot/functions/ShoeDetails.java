package com.sysco.the_athletes_foot.functions;

import com.sysco.the_athletes_foot.pages.ShoeDetailsPage;

public class ShoeDetails {

    public static ShoeDetailsPage shoeDetailsPage = new ShoeDetailsPage();


    public static void addShoeToCart(){
        shoeDetailsPage.clickOnShoeSizeMetrics();
        shoeDetailsPage.clickOnUSMensMetric();
        shoeDetailsPage.clickOnShoeNameLbl();
        shoeDetailsPage.selectShoeSize();
        shoeDetailsPage.clickOnAddToCartButton();
    }
}
