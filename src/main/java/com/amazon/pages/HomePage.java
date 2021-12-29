package com.amazon.pages;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (id = "twotabsearchtextbox")
    WebElement searchBox;

    @CacheLookup
    @FindBy (id = "nav-search-submit-button")
    WebElement searchButton;


    public void inputSearchTextIntoSearchBox(String text){
        doSendTextToElement(searchBox, text);
        CustomListeners.test.log(Status.PASS,"Enter search text into Search box " + text);
        Reporter.log("Enter Search text : '" + text + "' Search box" + "<br>");
    }

    public void clickOnSearchButton(){
        doClickOnElement(searchButton);
        CustomListeners.test.log(Status.PASS,"Click on Search Button ");
        Reporter.log("Click on search button  "  + "<br>");
    }

}
