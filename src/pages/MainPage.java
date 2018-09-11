package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    private static final String AMAZON_URL = "http://www.amazon.com";
    private static final By DEPARTMENT_CHOICE = By.id("nav-link-shopall");
    private static By MAIN_CATEGORY ;
    private static By DETAILED_CATEGORY;
    private static String MAIN_CATEGORY_DYNAMIC_XPATH = "//*[@aria-label='%s']";
    private static String DETAILED_CATEGORY_DYNAMIC_XPATH = "//span[contains(text(), '%s')]";


    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public MainPage getUrl() {
        driver.get(AMAZON_URL);
        return this;
    }


    public CategoryPage chooseCategory(String mainCategory, String detailedCategory) {

        MAIN_CATEGORY = By.xpath(String.format(MAIN_CATEGORY_DYNAMIC_XPATH, mainCategory));
        DETAILED_CATEGORY = By.xpath(String.format(DETAILED_CATEGORY_DYNAMIC_XPATH, detailedCategory));

        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(DEPARTMENT_CHOICE)).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MAIN_CATEGORY));
        hover.moveToElement(driver.findElement(MAIN_CATEGORY)).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DETAILED_CATEGORY));
        driver.findElement(DETAILED_CATEGORY).click();

        return new CategoryPage(driver, wait);
    }


}
