package com.amazon.testsuite;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.SearchResultPage;
import com.amazon.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class MobilePhoneTest extends TestBase {

    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productPage;

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void initialize() {
        homePage = new HomePage();
        searchResultPage = new SearchResultPage();
        productPage = new ProductPage();
    }


    @Test (groups = {"smoke"})
    public void verifyThatUserShouldAddMobilePhoneToCartSuccessfully() throws InterruptedException {
        homePage.inputSearchTextIntoSearchBox("Mobile Phone");
        homePage.clickOnSearchButton();
        searchResultPage.clickOnProduct("Samsung Galaxy A52 5G, Factory Unlocked Smartphone, Android Cell Phone, Water Resistant, 64MP Camera, US Version, 128GB, Black");
        productPage.selectQtyFromDropDown("2");
        productPage.clickOnAddToCart();
        Thread.sleep(1000);
        productPage.verifyMobileAddToCartMessage("Added to Cart");

    }

}

