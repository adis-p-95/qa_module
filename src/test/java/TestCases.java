import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCases {
    private static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void openMain() {
        System.setProperty("webdriver.chrome.driver", Configurations.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
    }

    @Test(testName = "TestCase1 - LoginAndHomePagesVerifications")
    public static void LoginTest() {
        driver.get(Configurations.BASE_URL);

        LoginPage loginPage = new LoginPage(driver, "standard_user", "secret_sauce");
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.pressLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);

        Assert.assertTrue(inventoryPage.isTitlePresent(), "Title is not present on page.");
        Assert.assertEquals(inventoryPage.getTitle(), "PRODUCTS", "Title is not PRODUCTS.");

        Assert.assertTrue(inventoryPage.isShoppingCartPresent(), "Shopping Cart is not present on page.");

        Assert.assertTrue(inventoryPage.isBurgerButtonPresent(), "Burger menu is not presented.");
        Assert.assertTrue(inventoryPage.isBurgerButtonInTheUpperLeftCorner(), "Burger menu is not in the upper left corner.");

        Assert.assertTrue(inventoryPage.isTwitterLinkPresent(), "Twitter link is not present on page.");
        Assert.assertEquals(inventoryPage.getTwitterLink(), "https://twitter.com/saucelabs", "Twitter link is not valid.");

        Assert.assertTrue(inventoryPage.isFacebookLinkPresent(), "Facebook link is not present on page.");
        Assert.assertEquals(inventoryPage.getFacebookLink(), "https://www.facebook.com/saucelabs", "Facebook link is not valid.");

        Assert.assertTrue(inventoryPage.isLinkedinLinkPresent(), "Linkedin link is not present on page.");
        Assert.assertEquals(inventoryPage.getLinkedinLink(), "https://www.linkedin.com/company/sauce-labs/", "Linkedin link is not valid.");

        Assert.assertFalse(inventoryPage.isLogoutPresent(), "Logout button presents even Burger Button is not clicked.");
        inventoryPage.pressBurgerButton();
        inventoryPage.waitForLogoutButton();
        Assert.assertTrue(inventoryPage.isLogoutPresent(), "Logout is not present on page.");
        inventoryPage.clickOnLogoutButton();

    }

    @Test(testName = "TestCase2 - Shopping")
    public static void ShoppingTest() {
        driver.get(Configurations.BASE_URL);
        LoginPage loginPage = new LoginPage(driver, "standard_user", "secret_sauce");

        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.pressLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.isBackpackItemPresent(), "Backpack item is not present on page.");
        inventoryPage.clickOnBackpackItem();

        InventoryItemPage backpackPage = new InventoryItemPage(driver);
        Assert.assertTrue(backpackPage.isTitlePresent(), "Title is not present on page.");
        Assert.assertEquals(backpackPage.getTitle(), "Sauce Labs Backpack", "Tile item is not present on page.");
        Assert.assertTrue(backpackPage.isDescriptionPresent(), "Item description is not present on page.");
        Assert.assertEquals(backpackPage.getDescription(), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", "Item description is not present on page.");
        Assert.assertTrue(backpackPage.isPricePresent(), "Price is not present on page.");
        Assert.assertEquals(backpackPage.getPrice(), "$29.99", "Item price is not present on page.");
        Assert.assertTrue(backpackPage.isAddToCartPresent(), "Add to cart button is not present on page.");
        backpackPage.clickOnAddToCart();

        Assert.assertTrue(backpackPage.isBackToProductPresent(), "Back to product button is not present on page.");
        backpackPage.clickOnBackToProducts();
        Assert.assertTrue(inventoryPage.isJacketItemPresent(), "Jacket item is not present on page.");
        Assert.assertTrue(inventoryPage.isJacketItemAddToCartPresent(), "Add to cart button is not present on page.");
        inventoryPage.clickJacketItemAddToCart();
        Assert.assertTrue(inventoryPage.isShoppingCartPresent(), "Shopping cart button is not present on page.");
        inventoryPage.clickOnShoppingCart();

        ShoppingCartPage shoppingcartPage = new ShoppingCartPage(driver);
        Assert.assertTrue(shoppingcartPage.isCheckoutButtonPresent(), "Checkout button is not present on page.");
        shoppingcartPage.clickOnCheckoutButton();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.isFirstNamePresent(), "First name is not present on page.");
        Assert.assertTrue(checkoutPage.isLastNamePresent(), "Last name is not present on page.");
        Assert.assertTrue(checkoutPage.isPostalCodePresent(), "Postal code is not present on page.");
        Assert.assertTrue(checkoutPage.isContinueButtonPresent(), "Continue button is not present on page.");

        checkoutPage.enterFirstName("Adis");
        checkoutPage.enterLastName("Pozegija");
        checkoutPage.enterPostalCode("71000");
        checkoutPage.clickOnContinueButton();

        Assert.assertTrue(checkoutPage.isFinishButtonPresent(), "Finish button is not present on page.");
        checkoutPage.clickOnFinishButton();

        Assert.assertTrue(checkoutPage.isCompleteHeaderPresent(), "Complete header is not present on page.");
        Assert.assertEquals(checkoutPage.getCompleteHeaderText(), "THANK YOU FOR YOUR ORDER", "Confirmation message is not correct.");

        Assert.assertFalse(inventoryPage.isLogoutPresent(), "Logout button presents even Burger Button is not clicked.");
        inventoryPage.pressBurgerButton();
        inventoryPage.waitForLogoutButton();
        Assert.assertTrue(inventoryPage.isLogoutPresent(), "Logout is not present on page.");
        inventoryPage.clickOnLogoutButton();
    }

    @AfterTest
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
