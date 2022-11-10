import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends PageObject {
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id=\"header_container\"]//div[@class=\"header_secondary_container\"]//span[@class=\"title\"]")
    private WebElement title;

    @FindBy(xpath = "//a[@class=\"shopping_cart_link\"]")
    private WebElement shopping_cart;

    @FindBy(className = "bm-burger-button")
    private WebElement burger_button;

    @FindBy(className = "social_twitter")
    private WebElement twitter_link;

    @FindBy(className = "social_facebook")
    private WebElement facebook_link;

    @FindBy(className = "social_linkedin")
    private WebElement linkedin_link;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout_link;

    @FindBy(xpath = "//div[text() = \"Sauce Labs Backpack\"]")
    private WebElement backpack_item;

    @FindBy(xpath = "//div[text() = \"Sauce Labs Fleece Jacket\"]")
    private WebElement jacket_item;

    @FindBy(xpath = "//div[text()=\"Sauce Labs Fleece Jacket\"]//..//..//..//div[@class=\"pricebar\"]//button")
    private WebElement jacket_item_add_to_cart;

    public boolean isTitlePresent() {
        return title.isDisplayed();
    }

    public String getTitle() {
        return title.getText();
    }

    public boolean isShoppingCartPresent() {
        return shopping_cart.isDisplayed();
    }

    public boolean isBurgerButtonPresent() {
        return burger_button.isDisplayed();
    }

    public boolean isBurgerButtonInTheUpperLeftCorner() {
        return burger_button.getLocation().getX() == 15 && burger_button.getLocation().getY() == 20;
    }

    public void pressBurgerButton() {
        burger_button.click();
    }

    public boolean isTwitterLinkPresent() {
        return twitter_link.isDisplayed();
    }

    public String getTwitterLink() {
        return twitter_link.findElement(By.tagName("a")).getAttribute("href");
    }

    public boolean isFacebookLinkPresent() {
        return facebook_link.isDisplayed();
    }
    public String getFacebookLink() {
        return facebook_link.findElement(By.tagName("a")).getAttribute("href");
    }

    public boolean isLinkedinLinkPresent() {
        return linkedin_link.isDisplayed();
    }

    public String getLinkedinLink() {
        return linkedin_link.findElement(By.tagName("a")).getAttribute("href");
    }

    public boolean isLogoutPresent() {
       return logout_link.isDisplayed();
    }

    public void waitForLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
    }

    public boolean isBackpackItemPresent() {
        return backpack_item.isDisplayed();
    }
    public void clickOnBackpackItem(){
        backpack_item.click();
    }

    public boolean isJacketItemPresent() {
        return jacket_item.isDisplayed();
    }

    public boolean isJacketItemAddToCartPresent() {
        return jacket_item_add_to_cart.isDisplayed();
    }

    public void clickJacketItemAddToCart() {
        jacket_item_add_to_cart.click();
    }

    public void clickOnShoppingCart() {
        shopping_cart.click();
    }

    public void clickOnLogoutButton() {
        logout_link.click();
    }
}
