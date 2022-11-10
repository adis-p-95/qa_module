import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageObject {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    private WebElement first_name;

    @FindBy(id = "last-name")
    private WebElement last_name;

    @FindBy(id = "postal-code")
    private WebElement postal_code;

    @FindBy(id = "continue")
    private WebElement continue_button;

    @FindBy(id = "finish")
    private WebElement finish_button;

    @FindBy(className = "complete-header")
    private WebElement complete_header;

    public boolean isFirstNamePresent() {
        return first_name.isDisplayed();
    }

    public boolean isLastNamePresent() {
        return last_name.isDisplayed();
    }

    public boolean isPostalCodePresent() {
        return postal_code.isDisplayed();
    }

    public void enterFirstName(String name) {
        first_name.sendKeys(name);
    }

    public void enterLastName(String name) {
        last_name.sendKeys(name);
    }

    public void enterPostalCode(String code) {
        postal_code.sendKeys(code);
    }

    public boolean isContinueButtonPresent() {
        return continue_button.isDisplayed();
    }

    public void clickOnContinueButton() {
        continue_button.click();
    }

    public boolean isFinishButtonPresent() {
        return finish_button.isDisplayed();
    }

    public void clickOnFinishButton() {
        finish_button.click();
    }

    public boolean isCompleteHeaderPresent() {
        return complete_header.isDisplayed();
    }

    public String getCompleteHeaderText() {
        return complete_header.getText();
    }
}