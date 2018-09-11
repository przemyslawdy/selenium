package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BestSellersInDesiredCategoryPage extends BasePage{

    private static By ITEM_NO;
    private static String ITEM_NO_DYNAMIC_XPATH = "//*[@id='zg-ordered-list']/li[%s]";

    public BestSellersInDesiredCategoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public ProductPage selectProductFromBestSellers(int itemNumber) {

       ITEM_NO = By.xpath(String.format(ITEM_NO_DYNAMIC_XPATH, itemNumber));

       driver.findElement(ITEM_NO).click();
       return new ProductPage(driver, wait);

    }

}

