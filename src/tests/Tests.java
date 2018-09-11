package tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class Tests {

    protected WebDriver driver;
    protected WebDriverWait wait;
    String productTitle;
    BigDecimal productPrice;
    int selectedQuantity;

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "res/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

    }

    @After
    public void tearDown() throws IOException {
        driver.manage().deleteAllCookies();
        driver.quit();
        Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");

    }


    @Given("^User is on amazon homepage$")
    public void navigateToAmazonHomePage() {
        new MainPage(driver, wait).getUrl();
    }

    @When("^User chooses category$")
    public void chooseProductCategory() {

        CategoryPage categoryPage = new MainPage(driver, wait)
                .chooseCategory("Electronics, Computers & Office", "Camera, Photo & Video");

        BestSellersPage bestSellersPage = categoryPage.gotoBestSellers();

        bestSellersPage
                .selectCategoryForBestSellers("Digital Cameras");
    }


    @And("^User selects item from Best Sellers$")
    public void selectItemFromBestSellers() {
        ProductPage productPage = new BestSellersInDesiredCategoryPage(driver, wait).selectProductFromBestSellers(5);
        productTitle = productPage.getProductTitle();
        productPrice = productPage.getPrice();
    }

    @And("^User selects quantity and adds product to cart$")
        public void addToCart() {
        ProductPage productPage = new ProductPage(driver, wait);
        productPage.addProductToCart(8);
        selectedQuantity = productPage.getSelectedQuantity();

    }

    @And("^User goes to cart page$")
    public void goToCart() {
        new ConfirmPage(driver, wait).viewCart();
    }

    @Then("^Product title is proper and subtotal price in cart is correct$")
    public void verifyProductTitleAndSubtotalPrice() {

        Assert.assertEquals(new CartPage(driver, wait).getProductTitleInCart(), productTitle);
        Assert.assertEquals(new CartPage(driver, wait).getSubtotalPriceInCart(), productPrice.multiply(new BigDecimal(selectedQuantity)));

    }
}



