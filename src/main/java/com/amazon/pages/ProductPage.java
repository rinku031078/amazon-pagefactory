package com.amazon.pages;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ProductPage extends Utility {

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (id = "add-to-cart-button")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(id = "quantity")
    WebElement selectQty;

    @CacheLookup
//    @FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
    @FindBy(xpath = "//div[@id='attachDisplayAddBaseAlert']//h4[@class='a-alert-heading'][normalize-space()='Added to Cart']")
    WebElement mobileAddToCartMessage;

    @CacheLookup
//    @FindBy(xpath = "//div[@id='attachDisplayAddBaseAlert']/div[1]/h4[1]")
    @FindBy(xpath = "//div[@id='attachDisplayAddBaseAlert']//h4[@class='a-alert-heading'][normalize-space()='Added to Cart']")
    WebElement laptopAddToCartMessage;



    public void selectQtyFromDropDown(String qty) {
        doSelectByValueFromDropDown(selectQty,qty);
        CustomListeners.test.log(Status.PASS, "Select Qty: ");
        Reporter.log("Select quantity from dropdown : '" + qty + "' dropdown" + "<br>");
    }

    public void clickOnAddToCart(){
        doClickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS, "Clicking on Add to Cart: ");
        Reporter.log("Click on Add to cart button : " + "<br>");
    }

    public void verifyLaptopAddToCartMessage(String message) throws InterruptedException {
        Thread.sleep(1000);
        String actualString = doGetTextFromElement(laptopAddToCartMessage);
        System.out.println("text of message: " + actualString);
        Assert.assertTrue(actualString.contains((message)));
        CustomListeners.test.log(Status.PASS, "Verify Add to cart message: ");
        Reporter.log("Verify product added to cart message : '" + message +  "<br>");
    }

    public void verifyMobileAddToCartMessage(String message) throws InterruptedException {
        Thread.sleep(1000);
        String actualString = doGetTextFromElement(mobileAddToCartMessage);
        System.out.println("text of message: " + actualString);
        Assert.assertTrue(actualString.contains((message)));
        CustomListeners.test.log(Status.PASS, "Verify Add to cart message: ");
        Reporter.log("Verify product added to cart message : " +  "<br>");
    }

}
