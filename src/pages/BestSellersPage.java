package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BestSellersPage extends BasePage {

    private static By MOST_DETAILED_CATEGORY;
    private static String MOST_DETAILED_CATEGORY_DYNAMIC_XPATH = "//a[contains(text(), '%s')]";

    public BestSellersPage(WebDriver driver, WebDriverWait wait) {
       super(driver, wait);
   }

    public BestSellersInDesiredCategoryPage selectCategoryForBestSellers(String mostDetailedCategory) {

        MOST_DETAILED_CATEGORY = By.xpath(String.format(MOST_DETAILED_CATEGORY_DYNAMIC_XPATH, mostDetailedCategory));

        driver.findElement(MOST_DETAILED_CATEGORY).click();
        return new BestSellersInDesiredCategoryPage(driver, wait);
    }

}

