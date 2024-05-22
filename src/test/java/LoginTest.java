import de.teleran.SideBar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void validDataWithPO() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        assertEquals("Products", inventoryPage.tittleTextIsProducts());

        //sleep(3000);
    }



    @Test
    public void  validData() throws InterruptedException {
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");


        //Enter the password field

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");


        //Click on login button

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();


        //Check that log in was successful

        WebElement logSuccessful = driver.findElement(By.className("inventory_list"));
        assertTrue(logSuccessful.isDisplayed());

        //poluchaem vse znachenie Url
        assertTrue(driver.getCurrentUrl().contains("/inventory"));

        sleep(3000);
    }

    @Test
    public void invalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("user-name");


       loginPage.enterValueToPassword("qwerty");

        //WebElement passwordField = driver.findElement(By.id("password"));
        //passwordField.sendKeys("secret_saucq");


        loginPage.clickOnLoginButton();
        //WebElement buttonLogin = driver.findElement(By.id("login-button"));
        //buttonLogin.click();

        assertTrue(loginPage.getErrorMessageText().contains("Username and password do not match any user in this service"));

        //WebElement header = driver.findElement(By.tagName("h3"));
        //assertTrue(header.getText().contains("Username and password do not match any user in this service"));

    }

    @Test
    public void invalidUserName(){


        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_useq");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        WebElement header = driver.findElement(By.tagName("h3"));
        assertTrue(header.getText().contains("Username and password do not match any user in this service"));

    }

    @Test
    public void onlyUserName(){

        //1. Empty Username
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();


        WebElement header = driver.findElement(By.tagName("h3"));
        assertTrue(header.getText().contains("Password is required"));

    }

    @Test
    public void onlyPassword(){

        //2.Empty password

        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();


        WebElement header = driver.findElement(By.tagName("h3"));
        assertTrue(header.getText().contains("Username is required"));

    }

    @Test
    public void withoutField(){

        //3.Empty creds

        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();


        WebElement header = driver.findElement(By.tagName("h3"));
        assertTrue(header.getText().contains("Username is required"));

    }

    @Test
    public void lockedUser() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("locked_out_user");
        //WebElement userNameInputField = driver.findElement(By.id("user-name"));
        //userNameInputField.sendKeys("locked_out_user");


        loginPage.enterValueToPassword("secret_sauce");
        //WebElement passwordField = driver.findElement(By.id("password"));
        //passwordField.sendKeys("secret_sauce");


        loginPage.clickOnLoginButton();
        //WebElement buttonLogin = driver.findElement(By.id("login-button"));
        //buttonLogin.click();



        assertTrue(loginPage.getErrorMessageText().contains("Sorry, this user has been locked out."));
        //WebElement header = driver.findElement(By.tagName("h3"));
        //assertTrue(header.getText().contains("Sorry, this user has been locked out."));

        //sleep(5000);
    }

    //logout

    @Test
    public void successLogout() throws InterruptedException {
        //log in with valid user
        //click on BurgerMenu
        //click on Logout link jf side bar(SideBar class)
        //Chick that logout is successful

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        assertEquals("Products", inventoryPage.tittleTextIsProducts());

        SideBar sideBar = new SideBar(driver);
        sideBar.clickOnBurgerMenu();

        //sleep(5000);
        sideBar.clickOnLogoutButton();

        assertTrue(loginPage.usernameInputFieldIsDisplayed());


        sleep(5000);
    }
}
