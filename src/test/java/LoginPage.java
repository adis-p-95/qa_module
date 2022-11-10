import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
    public LoginPage(WebDriver driver, String username, String password) {
        super(driver);
        this.username = username;
        this.password = password;
    }

    private String username;
    private String password;

    @FindBy(id = "user-name")
    private WebElement username_we;

    @FindBy(id = "password")
    private WebElement password_we;

    @FindBy(xpath = "//input[@id=\"login-button\"]")
    private WebElement login_button;

    @FindBy(xpath = "//div[@class=\"error-message-container error\"]")
    private WebElement error_message;

    public void enterUsername() {
        this.username_we.sendKeys(username);
    }

    public void enterPassword() {
        this.password_we.sendKeys(password);
    }

    public void pressLogin() {
        this.login_button.click();
    }

    public boolean errorMessage() {
        return error_message.isDisplayed();
    }

    public String getErrorMessage() {
        return error_message.getText();
    }

}
