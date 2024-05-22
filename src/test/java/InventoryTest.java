import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest{


    @Test
    public void itemsTest(){
        //log in

        //check that there are 6 items on yhe page

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        assertEquals("Products", inventoryPage.tittleTextIsProducts());

        //check all 6 items are displayed
        assertTrue(inventoryPage.allItemsAreDisplayed());

        //check that all item name are displayed
        assertTrue(inventoryPage.allItemsNamesAreDisplayed());

        assertTrue(inventoryPage.allItemNameAreNotEmpty());

        //all items name starts with "Sauce Labs"

        assertTrue(inventoryPage.allItemNameStartsSauceLabs());



    }
}
