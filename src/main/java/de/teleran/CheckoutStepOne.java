package de.teleran;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOne {
    WebDriver driver;

    public CheckoutStepOne(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;


    @FindBy(id = "continue")
    private WebElement continueButton;

    public void enterFirstName(String firstNameValue) {
        firstName.sendKeys(firstNameValue);
    }

    public void enterLastName(String lastNameValue) {
        lastName.sendKeys(lastNameValue);
    }


    public void enterPostalCode(String postalCodeValue) {
        postalCode.sendKeys(postalCodeValue);
    }

    public void clickToContinueButton() {
        continueButton.click();
    }
}
