import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeTestCases {

    private static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void openMain() {
        System.setProperty("webdriver.chrome.driver", Configurations.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
    }

    @DataProvider(name = "loginData")
    public static Object[][] LoginData(){
        return new Object[][]{
                {"username", "password"},
                {"standard_user", "secret"},
                {"user1", "secret_sauce"},
                {"12&", " "},
                {"", ""},
                {"", "testPass"},
                {"testUser", ""}
        };
    }

    @Test(testName = "IncorrectLogin", dataProvider = "loginData")
    public static void IncorrectLogin(String username, String password) {
        driver.get(Configurations.BASE_URL);
        LoginPage loginPage = new LoginPage(driver, username, password);

        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.pressLogin();

        Assert.assertTrue(loginPage.errorMessage(), "Error message is not present pn page.");

        if (username.isEmpty()) {
            Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required", "Error message is not correct.");
        } else if (password.isEmpty()) {
            Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required", "Error message is not correct.");
        } else {
            Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Error message is not correct.");
        }
    }

    @AfterTest
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
