package com.sysco.the_athletes_foot.functions;

import com.sysco.the_athletes_foot.pages.CheckoutPage;

public class Checkout {
    public static CheckoutPage checkoutPage = new CheckoutPage();


    public static void continueCheckout(){
        checkoutPage.clickOnContinue();
    }

    public static boolean isTheErrorMessageDisplayed(){
        return checkoutPage.isErrorMessageDisplayed();
    }

    public static void fillDeliveryDetails(String postcode,String address,String telephone) throws InterruptedException{
        checkoutPage.enterPostCode(postcode);
        checkoutPage.enterStreetAddress(address);
        checkoutPage.enterTelephone(telephone);
        Thread.sleep(5000);
    }

    public static void selectCreditCardPayment() throws InterruptedException{
        checkoutPage.selectCreditCardPaymentMethod();
    }

    public static void selectBillingAddressAsDeliveryAddress()throws InterruptedException{
        Thread.sleep(3000);
        checkoutPage.clickOnBillingAddressSameAsDeliveryAddressCheckBox();
    }

    public static void enterCreditCardNumber(String creditCardNumber){
        checkoutPage.enterCreditCardNumber(creditCardNumber);
    }

    public static void enterCreditCardMonth(String month){
        checkoutPage.enterCreditCardMonth(month);
    }

    public static void enterCreditCardYear(String year){
        checkoutPage.enterCreditCardYear(year);
    }

    public static void enterCreditCardCCV(String ccv){
        checkoutPage.enterCreditCardCCV(ccv);
    }

    public static void placeOrder(){
        checkoutPage.clickPlaceOrderButton();
    }

    public static boolean isCreditCardNumberErrorMessageDisplayed(){
        return checkoutPage.isCreditCardNumberValidationMessageDisplayed();
    }

    public static boolean isCreditCardMonthErrorMessageDisplayed(){
        return checkoutPage.isCreditCardMonthValidationMessageDisplayed();
    }

    public static boolean isCreditCardYearErrorMessageDisplayed(){
        return checkoutPage.isCreaitCardYearValidationMessageDisplayed();
    }
}
