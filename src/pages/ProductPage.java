package pages;

import components.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.math.BigDecimal;

public class ProductPage extends BasePage {

    private static final By QUANTITY = By.id("quantity");
    private static final By MAX_AVAILABLE_QT = By.cssSelector("#quantity > option:last-child");
    private static final By CART_BUTTON = By.id("add-to-cart-button");
    private static final By PRICE = By.id("priceblock_ourprice");
    private static final By PRODUCT_TITLE = By.id("productTitle");
    private static int SELECTED_QUANTITY = 0;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public ConfirmPage addProductToCart(int howMany) {

        int max = Integer.parseInt(driver.findElement(MAX_AVAILABLE_QT).getText());

        Select sel = new Select(driver.findElement(QUANTITY));

        if (howMany > max) {
            sel.selectByValue(String.valueOf(max));
            SELECTED_QUANTITY = max;
        }
        else {
            sel.selectByValue(String.valueOf(howMany));
            SELECTED_QUANTITY = howMany;
        }

        driver.findElement(CART_BUTTON).click();
        return new ConfirmPage(driver, wait);
    }



    public String getProductTitle(){
        return driver.findElement(PRODUCT_TITLE).getText();
    }


    public BigDecimal getPrice(){
        String price = driver.findElement(PRICE).getText();
        return Helpers.convertPriceToBigDecimal(price);

    }

    public int getSelectedQuantity(){
        return SELECTED_QUANTITY;
    }

}

