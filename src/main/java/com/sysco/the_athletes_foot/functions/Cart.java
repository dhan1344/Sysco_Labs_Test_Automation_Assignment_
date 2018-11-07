package com.sysco.the_athletes_foot.functions;

import com.sysco.the_athletes_foot.pages.CartPage;
import com.sysco.the_athletes_foot.pages.CheckoutPage;
import com.sysco.the_athletes_foot.pages.LandingPage;

public class Cart extends LandingPage {
    public static CartPage cartPage = new CartPage();
    public static CheckoutPage checkoutPage = new CheckoutPage();


    public static void navigateToSecureCheckout(){
        cartPage.clickOnSecureCheckOutButton();
        checkoutPage.waitTillDeliveryOrCollectionLableIsLoaded();
    }

    public static void waitTillThePageLoads(){
        cartPage.waitTillPageLoads();
    }
}
