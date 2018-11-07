package com.sysco.the_athletes_foot.tests;


import com.sysco.the_athletes_foot.functions.*;
import com.sysco.the_athletes_foot.utils.TestBase;
import fitlibraryGeneric.specify.workflow.Check;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Checkout");
    }

    @Test
    public void testLogin() throws Exception {


        SoftAssert softAssert = new SoftAssert();

        Landing.loadLandingPage();
        Login.navigateToLoginPage();

        softAssert.assertTrue(Login.isLoginPageDisplayed(),"The login page did not load successfully.");

        Login.login("williamjacob802@gmail.com","0okmNHY6");
        softAssert.assertEquals(Login.getFullNameOfUser(),"WILLIAM JACOB","The user name did not match the expected value.");

        //removing any items from the cart that may exist prior to test.
        if(Landing.doesTheCartHaveAnyItems()){
            Landing.clickOnShoppingCartQuickAccessPanel();
            Thread.sleep(5000);
            Landing.removeItemFromCart();
            Landing.reloadPage();
        }

        Landing.randomlySelectAShoe();
        ShoeDetails.addShoeToCart();

        Landing.reloadPage();
        Landing.clickOnShoppingCartQuickAccessPanel();
        Thread.sleep(5000);

        softAssert.assertEquals(Landing.getShoesSelected().get(0).getProductName(),Landing.getShoppingCartProductName());
        softAssert.assertEquals(Landing.getShoesSelected().get(0).getPrice(),Landing.getShoppingCartProductPrice());

        Landing.navigateToShoppingCart();
        Thread.sleep(5000);
        Cart.navigateToSecureCheckout();
        Checkout.continueCheckout();
        Thread.sleep(5000);
        softAssert.assertTrue(Checkout.isTheErrorMessageDisplayed(),"the checkout page validation message was not found.");
        Checkout.fillDeliveryDetails("2000","100 Fort Worth", "111111111");
        Checkout.continueCheckout();
        Checkout.selectCreditCardPayment();
        Checkout.selectBillingAddressAsDeliveryAddress();
        Thread.sleep(3000);

        //validating the Credit Card Information Fields
        Checkout.placeOrder();
        softAssert.assertTrue(Checkout.isCreditCardNumberErrorMessageDisplayed(),"Credit Card number validation not shown.");
        Checkout.enterCreditCardNumber("4910149950955662");
        Checkout.placeOrder();
        softAssert.assertTrue(Checkout.isCreditCardMonthErrorMessageDisplayed(),"Credit Card month validation not shown.");
        softAssert.assertTrue(Checkout.isCreditCardYearErrorMessageDisplayed(),"Credit Card year validation not shown");
        Checkout.enterCreditCardMonth("00");
        Checkout.enterCreditCardYear("19");
        Checkout.placeOrder();
        softAssert.assertTrue(Checkout.isCreditCardMonthErrorMessageDisplayed(),"Credit Card month validation not shown.");
        softAssert.assertTrue(Checkout.isCreditCardYearErrorMessageDisplayed(),"Credit Card year validation not shown");

        Checkout.enterCreditCardMonth("05");
        Checkout.enterCreditCardYear("19");
        Checkout.enterCreditCardCCV("223");

        Thread.sleep(5000);


        softAssert.assertAll();
        Login.quiteDriver();

    }
}