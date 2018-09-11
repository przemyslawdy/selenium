package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmPage extends BasePage {

    private static final By CART = By.id("hlb-view-cart");

    public ConfirmPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public CartPage viewCart() {
        driver.findElement(CART).click();
        return new CartPage(driver, wait);
    }

}

