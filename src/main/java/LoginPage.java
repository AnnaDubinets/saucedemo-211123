import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    private WebElement usernameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement header;

    public void enterValueToUsername(String usernameValue){
        usernameInputField.sendKeys(usernameValue);
    }

    public void enterValueToPassword(String passwordValue){
        passwordInputField.sendKeys(passwordValue);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public String getErrorMessageText() {
        return header.getText();
    }

    public boolean usernameInputFieldIsDisplayed(){
        return usernameInputField.isDisplayed();
    }
}



