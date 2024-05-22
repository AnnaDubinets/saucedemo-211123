import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "cart_item")
    private List<WebElement> addedItems;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemsName;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;





    public int getAddedItemsQuantity(){
        return addedItems.size();
    }

    public String getNameOfFirstItem(){
        return  itemsName.get(0).getText();
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }



}
