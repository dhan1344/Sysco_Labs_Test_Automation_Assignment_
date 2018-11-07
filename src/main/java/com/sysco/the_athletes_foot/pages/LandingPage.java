package com.sysco.the_athletes_foot.pages;

import com.sysco.the_athletes_foot.common.Constants;
import com.sysco.the_athletes_foot.data.ProductData;
import com.sysco.the_athletes_foot.functions.ShoeDetails;
import com.sysco.the_athletes_foot.utils.XPathUtils;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rifad on 5/21/18.
 */
public class LandingPage {
    protected static SyscoLabUI syscoLabUIOgm;
    protected static ArrayList<ProductData> shoesSelected = new ArrayList<>();

    private By lnkShoppingCart = By.xpath("/html/body/div[2]/header/div[2]/div/div[4]/span/span");
    private By lnkShopingCartNumberOfItems = By.xpath("/html/body/div[2]/header/div[2]/div/div[4]/span/span/span");
    private By btnRemoveItemFromCart = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[1]/div[1]/div/a[2]");
    private By btnConfirmItemRemoval = By.xpath("/html/body/div[6]/aside[2]/div[2]/footer/button[2]");
    private By lnkMensCategory = By.xpath("//*[@id=\"mi-1-2\"]");
    private By lblShoppingCartProductName = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[1]/div[1]/div/div[1]/strong/a");
    private By lblShoppingCartProductPrice = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/div[2]/div/span/span/span/span");
    private By btnViewCart = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[2]/div[1]/div/a");
    private By btnCloseShoppingCartQuickAccessPanel = By.xpath("//*/strong[starts-with(text(),'Shopping Cart')]");
    private By lblFullName = By.xpath("/html/body/div[2]/header/div[1]/div[1]/ul/li[2]/span/span");

    private String lnkSubCategoryXPath = "//*[@id=\"mi-3-2-3-X\"]";
    private String lnkShoeXpath = "//*[@id=\"ewave-layerednavigation-product-list\"]/div[2]/ul/li[X]/div/div[2]/a/span/span/div/img";
    private String lblShoeName = "//*[@id=\"ewave-layerednavigation-product-list\"]/div[2]/ul/li[X]/div/div[3]/strong/a";
    private String lblShoePrice = "//*[@id=\"ewave-layerednavigation-product-list\"]/div[2]/ul/li[X]/div/div[3]/div/span/span/span";


    public static void loadLandingPage(Capabilities capabilities, String url) {
        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        syscoLabUIOgm.driver.manage().window().maximize();
        syscoLabUIOgm.driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    public void clickOnShoppingCartQuickAccessPanel(){
        syscoLabUIOgm.click(lnkShoppingCart);
    }

    public void waitTillShoppingCartQuickAccessPanelIsDisplayed(){
        syscoLabUIOgm.waitTillElementLoaded(btnCloseShoppingCartQuickAccessPanel,5000);
    }

    public int getNumberOfItemsInCart(){
        int i = Integer.parseInt(syscoLabUIOgm.getText(lnkShopingCartNumberOfItems));
        return i;
    }

    public boolean isNumberOfItemsIconDisplayed(){
        return syscoLabUIOgm.isDisplayed(lnkShopingCartNumberOfItems);
    }

    public void clickRemoveItemFromCartButton(){
        syscoLabUIOgm.click(btnRemoveItemFromCart);
    }

    public void clickConfirmItemRemove(){
        syscoLabUIOgm.waitTillElementLoaded(btnConfirmItemRemoval,5000);
        syscoLabUIOgm.click(btnConfirmItemRemoval);
    }

    public void clickOnMensCategory(){
        syscoLabUIOgm.click(lnkMensCategory);
    }

    public void clickOnASubCategory(){
        String generatedXpath = XPathUtils.generateXPathInRange(lnkSubCategoryXPath,"X",1,9);
        By lnkSubCategoryLink = By.xpath(generatedXpath);
        syscoLabUIOgm.click(lnkSubCategoryLink);
    }

    public void clickOnARandomShoe(){
        int shoeSelection = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        String shoeSelectionXpath = XPathUtils.generateXPath(lnkShoeXpath,"X",Integer.toString(shoeSelection));
        String shoeNameXpath = XPathUtils.generateXPath(lblShoeName,"X",Integer.toString(shoeSelection));
        String shoePriceXpath = XPathUtils.generateXPath(lblShoePrice,"X",Integer.toString(shoeSelection));

        By lnkShoeSelection = By.xpath(shoeSelectionXpath);
        By lblShoeName = By.xpath(shoeNameXpath);
        By lblShoePrice = By.xpath(shoePriceXpath);

        ProductData product = new ProductData();
        product.setProductName(syscoLabUIOgm.getText(lblShoeName));
        product.setPrice(syscoLabUIOgm.getText(lblShoePrice));

        shoesSelected.add(product);
        syscoLabUIOgm.click(lnkShoeSelection);
    }

    public ArrayList<ProductData> getshoesSelected(){
        return shoesSelected;
    }

    public String getShoppingCartProductName(){
        return syscoLabUIOgm.getText(lblShoppingCartProductName);
    }

    public String getShoppingCartProductPrice(){
        return syscoLabUIOgm.getText(lblShoppingCartProductPrice);
    }

    public void clickOnViewCartButton(){
        syscoLabUIOgm.moveToAndClick(btnViewCart);
    }

    public void quitDriver() {
        if (syscoLabUIOgm != null) {
            syscoLabUIOgm.quit();
        }
    }

    public void reloadPage(){
        syscoLabUIOgm.navigateTo(Constants.APP_URL);
    }

    public void waitTillPageLoads(){
        syscoLabUIOgm.waitTillElementLoaded(lblFullName,5000);
    }



}
