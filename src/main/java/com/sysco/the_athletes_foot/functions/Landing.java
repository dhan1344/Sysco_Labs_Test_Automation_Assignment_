package com.sysco.the_athletes_foot.functions;

import com.sysco.the_athletes_foot.common.Constants;
import com.sysco.the_athletes_foot.data.ProductData;
import com.sysco.the_athletes_foot.pages.LandingPage;
import com.sysco.the_athletes_foot.pages.ShoeDetailsPage;
import com.sysco.the_athletes_foot.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;

public class Landing {

    public static LandingPage landingPage = new LandingPage();
    public static ShoeDetailsPage shoeDetailsPage = new ShoeDetailsPage();

    public static void loadLandingPage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            landingPage.loadLandingPage(capabilities, Constants.APP_URL);
        } else {
            landingPage.loadLandingPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }

    public static void clickOnShoppingCartQuickAccessPanel(){
        landingPage.clickOnShoppingCartQuickAccessPanel();
        //landingPage.waitTillShoppingCartQuickAccessPanelIsDisplayed();
    }

    public static int geTheNumberOfItemsInCart(){
        return landingPage.getNumberOfItemsInCart();
    }

    public static boolean doesTheCartHaveAnyItems(){
        return landingPage.isNumberOfItemsIconDisplayed();
    }

    public static void removeItemFromCart(){
        landingPage.clickRemoveItemFromCartButton();
        landingPage.clickConfirmItemRemove();
    }

    public static void randomlySelectAShoe(){
        landingPage.clickOnMensCategory();
        landingPage.clickOnASubCategory();
        landingPage.clickOnARandomShoe();
        shoeDetailsPage.waitTillPageLoads();
    }

    public static ArrayList<ProductData> getShoesSelected(){
        return landingPage.getshoesSelected();
    }

    public static void navigateToShoppingCart(){
        landingPage.clickOnViewCartButton();

    }

    public static void reloadPage() throws InterruptedException{
        landingPage.reloadPage();
        landingPage.waitTillPageLoads();
    }

    public static String getShoppingCartProductName(){
        return landingPage.getShoppingCartProductName();
    }

    public static String getShoppingCartProductPrice(){
        return landingPage.getShoppingCartProductPrice();
    }


}
