package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage extends BasePage {

    private static final By BEST_SELLERS = By.xpath("//span[contains(text(), 'Best Sellers')]");

    public CategoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public BestSellersPage gotoBestSellers() {
        driver.findElement(BEST_SELLERS).click();
        return new BestSellersPage(driver, wait);
    }

}

