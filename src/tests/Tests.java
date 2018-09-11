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
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import pages.*;

public class Tests {

    private WebDriver driver;
    private WebDriverWait wait;
    private String productTitle;
    private BigDecimal productPrice;
    private int selectedQuantity;

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "res/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
       // Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");

    }


    @Given("^User is on amazon homepage$")
    public void navigateToAmazonHomePage() {
        new MainPage(driver, wait).getUrl();
    }


    @When("^User chooses category \"([^\"]*)\" -> \"([^\"]*)\" -> \"([^\"]*)\"$")
    public void userChoosesCategory(String mainCategory, String detailedCategory, String mostDetailedCategory) {
        CategoryPage categoryPage = new MainPage(driver, wait)
                .chooseCategory(mainCategory, detailedCategory);

        BestSellersPage bestSellersPage = categoryPage.gotoBestSellers();

        bestSellersPage
                .selectCategoryForBestSellers(mostDetailedCategory);
    }



    @And("^User selects item no (\\d+) from Best Sellers$")
    public void userSelectsItemFromBestSellers(int itemNumber) {
        ProductPage productPage = new BestSellersInDesiredCategoryPage(driver, wait).selectProductFromBestSellers(itemNumber);
        productTitle = productPage.getProductTitle();
        productPrice = productPage.getPrice();

    }


    @And("^User selects (\\d+) pieces and adds product to cart$")
    public void userSelectsPiecesAndAddsProductToCart(int howMany) {
        ProductPage productPage = new ProductPage(driver, wait);
        productPage.addProductToCart(howMany);
        selectedQuantity = productPage.getSelectedQuantity();
    }


    @And("^User goes to cart page$")
    public void goToCart() {
        new ConfirmPage(driver, wait).viewCart();
    }

    @Then("^Product title is proper and subtotal price in cart is correct$")
    public void verifyProductTitleAndSubtotalPrice() {

        CartPage cartPage = new CartPage(driver,wait);
        Assert.assertEquals(cartPage.getProductTitleInCart(), productTitle);
        Assert.assertEquals(cartPage.getSubtotalPriceInCart(), productPrice.multiply(new BigDecimal(selectedQuantity)));

    }



}



