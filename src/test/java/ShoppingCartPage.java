import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageObject {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "checkout")
    private WebElement checkout_button;

    public boolean isCheckoutButtonPresent() {
        return checkout_button.isDisplayed();
    }

    public void clickOnCheckoutButton() {
        checkout_button.click();
    }
}


