package com.sysco.the_athletes_foot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class CheckoutPage extends LandingPage{

    private By lblDeliveryOrCollection = By.xpath("//*[@id=\"checkout\"]/div[1]/ul/li[1]/span");
    private By lblFirstName = By.xpath("//*[@name=\"firstname\"]");
    private By lblLastName = By.xpath("//*[@name=\"lastname\"]");
    private By btnContinue = By.xpath("//*[@id=\"checkout\"]/div[2]/div[1]/div[3]/button");
    private By lblMandatoryField = By.xpath("//*[text()='This is a required field.']");
    private By txtPostcode= By.xpath("//*[@name=\"postcode\"]");
    private By txtStreetName = By.xpath("//*[@name=\"street[0]\"]");
    private By txtTelephone = By.xpath("//*[@name=\"telephone\"]");
    private By chkCreditCardPaymentMethod = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[1]/label/strong");
    private By txtCreditCardNumber = By.xpath("//input[@name=\"credit-card-number\"]");
    private By lblCreditCardNumberErrorMessage = By.xpath("//*[@id=\"payment_form_braintree\"]/div[2]/div/div[2]/span");
    private By lblCreditCardMonthErrorMessage = By.xpath("//*[@id=\"payment_form_braintree\"]/div[3]/div/div[1]/div[2]/span");
    private By lblCreditCardYearErrorMessage = By.xpath("//*[@id=\"payment_form_braintree\"]/div[3]/div/div[1]/div[2]/span");
    private By chkBillingandDeliveryAddressIsTheSame = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[2]/div[2]/div/div[1]/label");
    private By txtCreditCardMonth = By.xpath("//*[@id=\"expiration-month\"]");
    private By txtCreditCardYear = By.xpath("//*[@id=\"expiration-year\"]");
    private By txtCreditCardCCV = By.xpath("//*[@id=\"cvv\"]");
    private By btnPlaceOrder = By.xpath("//*[@id=\"checkout\"]/div[2]/div[1]/div[3]/button");

    private By iFramecreditCardNumber = By.xpath("//*[@id=\"braintree-hosted-field-number\"]");
    private By iFrameCreditCardMonth = By.xpath("//*[@id=\"braintree-hosted-field-expirationMonth\"]");
    private By iFrameCreditCardYear = By.xpath("//*[@id=\"braintree-hosted-field-expirationYear\"]");
    private By iFrameCreditCardCCV = By.xpath("//*[@id=\"braintree-hosted-field-cvv\"]");

    public void waitTillDeliveryOrCollectionLableIsLoaded(){
        syscoLabUIOgm.waitTillElementLoaded(lblDeliveryOrCollection,5000);
    }

    public void enterStreetAddress(String address){
        syscoLabUIOgm.sendKeys(txtStreetName,address);
    }

    public void enterTelephone(String telephone){
        syscoLabUIOgm.sendKeys(txtTelephone,telephone);
    }

    public void selectCreditCardPaymentMethod() throws InterruptedException{
        syscoLabUIOgm.waitTillElementLoaded(chkCreditCardPaymentMethod,5000);
        Thread.sleep(3000);
        syscoLabUIOgm.click(chkCreditCardPaymentMethod);
    }

    public void enterCreditCardNumber(String creditCardNumber){
        syscoLabUIOgm.switchToFrame(iFramecreditCardNumber);
        syscoLabUIOgm.sendKeys(txtCreditCardNumber,creditCardNumber);
        syscoLabUIOgm.switchToDefaultFrame();
    }

    public void clickOnBillingAddressSameAsDeliveryAddressCheckBox(){

        if(!syscoLabUIOgm.isSelected(chkBillingandDeliveryAddressIsTheSame)){
            syscoLabUIOgm.click(chkBillingandDeliveryAddressIsTheSame);
        }

        syscoLabUIOgm.click(chkBillingandDeliveryAddressIsTheSame);
    }

    public boolean isCreditCardNumberValidationMessageDisplayed(){
        return syscoLabUIOgm.isDisplayed(lblCreditCardNumberErrorMessage);
    }

    public boolean isCreditCardMonthValidationMessageDisplayed(){
        return syscoLabUIOgm.isDisplayed(lblCreditCardMonthErrorMessage);
    }

    public boolean isCreaitCardYearValidationMessageDisplayed(){
        return syscoLabUIOgm.isDisplayed(lblCreditCardYearErrorMessage);
    }

    public void clickPlaceOrderButton(){
        /*if(!syscoLabUIOgm.isClickable(btnPlaceOrder)){
            syscoLabUIOgm.click(chkBillingandDeliveryAddressIsTheSame);
        }*/
        syscoLabUIOgm.click(btnPlaceOrder);
    }


    public void enterPostCode(String postcode)throws InterruptedException{
        syscoLabUIOgm.sendKeys(txtPostcode,postcode);
        Thread.sleep(5000);
        syscoLabUIOgm.sendKeys(txtPostcode, Keys.ARROW_DOWN);
        syscoLabUIOgm.sendKeys(txtPostcode, Keys.ENTER);
    }

    public void enterCreditCardMonth(String month){
        syscoLabUIOgm.switchToFrame(iFrameCreditCardMonth);
        syscoLabUIOgm.sendKeys(txtCreditCardMonth,month);
        syscoLabUIOgm.switchToDefaultFrame();
    }

    public void enterCreditCardYear(String year){
        syscoLabUIOgm.switchToFrame(iFrameCreditCardYear);
        syscoLabUIOgm.sendKeys(txtCreditCardYear,year);
        syscoLabUIOgm.switchToDefaultFrame();
    }

    public void enterCreditCardCCV(String ccv){
        syscoLabUIOgm.switchToFrame(iFrameCreditCardCCV);
        syscoLabUIOgm.sendKeys(txtCreditCardCCV,ccv);
        syscoLabUIOgm.switchToDefaultFrame();
    }

    public String getFirstName(){
        return syscoLabUIOgm.getText(lblFirstName);
    }

    public String getLastName(){
        return syscoLabUIOgm.getText(lblLastName);
    }

    public boolean isErrorMessageDisplayed(){
        return syscoLabUIOgm.isDisplayed(lblMandatoryField);
    }
    public void clickOnContinue(){
        syscoLabUIOgm.click(btnContinue);
    }
}
