import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryItemPage extends PageObject {

    public InventoryItemPage(WebDriver driver) {
        super(driver);
    } //Constructor

    @FindBy(xpath = "//div[@class=\"inventory_details_name large_size\"]")
    private WebElement title;

    @FindBy(xpath = "//div[@class=\"inventory_details_desc large_size\"]")
    private WebElement description;

    @FindBy(className = "inventory_details_price")
    private WebElement price;

    @FindBy(xpath = "//button[text() = \"Add to cart\"]")
    private WebElement add_to_cart;

    @FindBy(id = "back-to-products")
    private WebElement back_to_products;

    public boolean isTitlePresent() {
        return title.isDisplayed();
    }

    public boolean isDescriptionPresent() {
        return description.isDisplayed();
    }

    public boolean isPricePresent() {
        return price.isDisplayed();
    }

    public boolean isAddToCartPresent() {
        return add_to_cart.isDisplayed();
    }

    public void clickOnAddToCart() {
        add_to_cart.click();
    }

    public boolean isBackToProductPresent() {
        return back_to_products.isDisplayed();
    }

    public void clickOnBackToProducts() {
        back_to_products.click();
    }

    public void waitForBackToProducts() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("back-to-products")));
    }
    public String getTitle() {
        return title.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getPrice() {
        return price.getText();
    }
}
