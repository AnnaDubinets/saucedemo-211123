package de.teleran;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SucccheckoutCompleteessPage {
    WebDriver driver;
    public SucccheckoutCompleteessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "complete-header")
    private WebElement header;

    public String successCheckoutText(){
        return header.getText();
    }
}
