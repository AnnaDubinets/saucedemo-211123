import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void add1ItemTest(){


        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        assertEquals("Products", inventoryPage.tittleTextIsProducts());


        //add to cart backpack (1st item)

        inventoryPage.clickAddToCard();


        //Check that cart icon has badge with text "1"

        assertEquals("1",inventoryPage.getCartBadgeText());


    }


    @Test
    public void add3Items(){
        //Add 3 items to the cart

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        assertEquals("Products", inventoryPage.tittleTextIsProducts());

        inventoryPage.clickAddToCard();
        inventoryPage.clickAddToCardLight();
        inventoryPage.clickAddToCardTShirt();


        //Check that cart icon has badge with text "3"

        assertEquals("3",inventoryPage.getCartBadgeText());

    }


    @Test
    public void cart1ItemTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        assertEquals("Products", inventoryPage.tittleTextIsProducts());

        //add 1 item to the cart
        //go to Cart page

        inventoryPage.clickAddToCard();
        inventoryPage.clickShoppingCardLink();


        //check that 1 item in the list

        inventoryPage.clickOnTheCardIcon();

        CartPage cartPage = new CartPage(driver);
        assertEquals(1, cartPage.getAddedItemsQuantity());

        //check that item name from Cart page equals to item name, which was added
        assertEquals(inventoryPage.getNameOfTheFirstItem(),cartPage.getNameOfFirstItem());


        sleep(5000);

    }


    //Check that 5 items are added to the cart
    @Test
    public void cart5ItemsTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        assertEquals("Products", inventoryPage.tittleTextIsProducts());

        //add 1 item to the cart
        //go to Cart page

        inventoryPage.clickAddToCard();
        inventoryPage.clickAddToCardLight();
        inventoryPage.clickAddToCardTShirt();
        inventoryPage.clickOnJacketAddToCartButton();
        inventoryPage.clickOnOnisieAddToCartButton();

        inventoryPage.clickShoppingCardLink();

        inventoryPage.clickOnTheCardIcon();

        CartPage cartPage = new CartPage(driver);
        assertEquals(5, cartPage.getAddedItemsQuantity());
    }
}
