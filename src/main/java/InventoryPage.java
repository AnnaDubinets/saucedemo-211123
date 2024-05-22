import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryPage {
    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-test=\"title\"]")
    private WebElement titleText;

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;


    @FindBy(className = "inventory_item")
    private List<WebElement> items;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCardBackPack;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addToCartBikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addToCartBoltTShirt;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy(className = "cart_quantity")
    private WebElement cartQuantity;


    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;


    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addToCardJacket;

    //adauga Onisie in produs in cos
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement addToCardOniesie;

    public boolean inventoryListIsDisplayed() {
        return inventoryList.isDisplayed();
    }

    public String tittleTextIsProducts() {
        return titleText.getText();
    }

    public int itemCount() {
        return items.size();
    }

    public boolean allItemsAreDisplayed() {
        boolean displayed = true;
        for (WebElement item : items) {
            if (!item.isDisplayed()) {
                displayed = false;
            }
        }
        return displayed;

    }

    public boolean allItemsNamesAreDisplayed() {
        boolean displayed = true;
        for (WebElement itemName : itemNames) {
            if (!itemName.isDisplayed()) {
                displayed = false;
            }
        }
        return displayed;
    }

    public boolean allItemNameAreNotEmpty() {
        boolean notEmpty = true;
        for (WebElement itemName : itemNames) {
            if (itemName.getText().isEmpty()) {
                notEmpty = false;
            }
        }
        return notEmpty;
    }

    public boolean allItemNameStartsSauceLabs() {
        boolean sauceLabs = true;
        for (WebElement itemName : itemNames) {
            if (!itemName.getText().startsWith("Sauce Labs")) ;
            sauceLabs = false;
        }
        return sauceLabs;
    }


    public void clickAddToCard() {
        addToCardBackPack.click();
    }

    public String getCartBadgeText() {
        return cartBadge.getText();
    }

    public void clickAddToCardLight() {
        addToCartBikeLight.click();
    }

    public void clickAddToCardTShirt() {
        addToCartBoltTShirt.click();
    }

    public void clickShoppingCardLink() {
        shoppingCartLink.click();
    }

    public String getCheckCartQuantity() {
        return cartQuantity.getText();
    }

    public void clickOnTheCardIcon() {
        cartIcon.click();
    }

    public void clickOnJacketAddToCartButton() {
        addToCardJacket.click();
    }

    public void clickOnOnisieAddToCartButton() {
        addToCardOniesie.click();
    }

    public String getNameOfTheFirstItem() {
        return itemNames.get(0).getText();
    }

}
