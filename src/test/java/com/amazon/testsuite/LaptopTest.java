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
public class LaptopTest extends TestBase {

    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productPage;

    @BeforeMethod (groups = {"sanity", "smoke", "regression"})
    public void initialize(){
        homePage = new HomePage();
        searchResultPage = new SearchResultPage();
        productPage = new ProductPage();

    }

    @Test (groups = {"sanity"})
    public void verifyThatUserShouldAddLaptopToCartSuccessfully() throws InterruptedException {
        homePage.inputSearchTextIntoSearchBox("Laptop");
        homePage.clickOnSearchButton();
//        searchResultPage.clickOnProduct("ASUS ROG Zephyrus S15 Gaming Laptop, 300Hz 15.6\" FHD 3ms IPS Level, Intel Core i7-10875H, NVIDIA GeForce RTX 2080 Super, 32GB DDR4, 1TB RAID 0 SSD, Wi-Fi 6, Per-Key RGB, Windows 10 Pro, GX502LXS-XS79");
//        searchResultPage.clickOnProduct("ASUS ZenBook Pro Duo UX581 Laptop, 15.6” 4K UHD NanoEdge Touch Display, Intel Core i7-10750H, 16GB RAM, 1TB PCIe SSD, GeForce RTX 2060, ScreenPad Plus, Windows 10 Pro, Celestial Blue, UX581LV-XS74T");
        searchResultPage.clickOnProduct("ASUS L410 MA-DB04 Ultra Thin Laptop, 14” FHD Display, Intel Celeron N4020 Processor, 4GB RAM, 128GB Storage, NumberPad, Windows 10 Home in S Mode, Star Black");
        productPage.selectQtyFromDropDown("3");
        productPage.clickOnAddToCart();
        Thread.sleep(1000);
        productPage.verifyLaptopAddToCartMessage("Added to Cart");
    }

}
