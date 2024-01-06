package pages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import static constants.Constant.PRODUCT_CODE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogTileCardSearch extends BasePage {

    public CatalogTileCardSearch(WebDriver driver) {
        super(driver);
    }

    By searchPlace = By.xpath("//*[@id=\"__next\"]/div[2]/header/div[1]/div[2]/div/div/div/div/div/input");
    By searchBtn = By.xpath("//button[@data-testid=\"catalog-search-button\"]");
    By codeProduct = By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[3]/div/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/span[2]");

    public CatalogTileCardSearch inputData() {
        driver.findElement(searchPlace).clear();
        driver.findElement(searchPlace).sendKeys(PRODUCT_CODE);
        return this;
    }

    public CatalogTileCardSearch clickSearch() {
        driver.findElement(searchBtn).click();
        return this;
    }

    public CatalogTileCardSearch checkResult() {
        String valueOfProductCode = driver.findElement(codeProduct).getText();
        assertEquals("ETM" + PRODUCT_CODE, valueOfProductCode);
        return this;
    }
}
