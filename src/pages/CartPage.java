package pages;

import components.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.math.BigDecimal;

public class CartPage extends BasePage {

    private static final By SUBTOTAL_PRICE = By.id("sc-subtotal-amount-activecart");
    private static final By PRODUCT_TITLE = By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getProductTitleInCart(){
        return driver.findElement(PRODUCT_TITLE).getText();

    }

    public BigDecimal getSubtotalPriceInCart(){
        String price = driver.findElement(SUBTOTAL_PRICE).getText();
        return Helpers.convertPriceToBigDecimal(price);

    }




}

