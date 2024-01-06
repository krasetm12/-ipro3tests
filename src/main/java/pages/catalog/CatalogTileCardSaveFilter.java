package pages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static constants.Constant.TimeOutVariables.EXPLICIT_WAIT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogTileCardSaveFilter extends BasePage {
    public CatalogTileCardSaveFilter(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(EXPLICIT_WAIT));
    JavascriptExecutor scroller = (JavascriptExecutor) driver;
    By listOfManufacturers = By.xpath("//*[@id=\"panel1a-header\"]/div[2]");
    By brandSearch = By.xpath("//*[@id=\"panel1a-content\"]/div/div/div[1]/div/input");
//    By brandClick = By.xpath("//input[@data-testid=\"checkbox-filterBrand_Конкорд\"]");
    By brandClick = By.xpath("//label[contains(text(), 'Конкорд')]");
    By listOfViens = By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[5]/div/div[2]/div[1]/div/div[4]/div[4]");
    By veinsClick = By.xpath("//label[contains(text(),'3')]");
    By fromRus = By.xpath("//span[(text()='Сделано в России / ЕАЭС')]");
    By enterFilters = By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[5]/div/div[2]/div[1]/div/div[6]/button[2]");
//    By enterFiltersCss = By.cssSelector("button.jss355:nth-child(2) > span:nth-child(1)");
    //    By saveFilters = By.xpath("//input[@data-testid=\"save-filter-button\"]");
    By saveFilters = By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[5]/div/div[1]/div[2]/div[3]/button");
    By acceptSavedFilter = By.xpath("//*[@id=\"portal\"]/div/div[2]/div[2]/table/tbody/tr[1]/td[3]/div/button[3]");

    By myFiltersBtn = By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[5]/div/div[1]/div[1]/div/div/button");


    public CatalogTileCardSaveFilter brandChoose() {
        scroller.executeScript("window.scrollBy(0,300)");
        driver.findElement(listOfManufacturers).click();
        driver.findElement(brandSearch).sendKeys("Конкорд");
        wait.until(ExpectedConditions.visibilityOfElementLocated(brandClick));
        driver.findElement(brandClick).click();
        return this;
    }

    public CatalogTileCardSaveFilter veinsChoose() {
        driver.findElement(listOfViens).click();
        scroller.executeScript("window.scrollBy(0,300)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(veinsClick));
        driver.findElement(veinsClick).click();
        return this;
    }

    public CatalogTileCardSaveFilter fromRusChoose() {
        scroller.executeScript("window.scrollBy(0,700)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromRus));
        driver.findElement(fromRus).click();
        return this;
    }
    public CatalogTileCardSaveFilter enterAllFilters() {
        scroller.executeScript("window.scrollBy(0,700)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterFilters));
        driver.findElement(enterFilters).click();
        return this;
    }

    public CatalogTileCardSaveFilter saveAllFilters() {
        scroller.executeScript("window.scrollBy(0,-1200)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveFilters));
        driver.findElement(saveFilters).click();
        return this;
    }

    public CatalogTileCardSaveFilter chooseSavedFilter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myFiltersBtn));
        driver.findElement(myFiltersBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(acceptSavedFilter));
        driver.findElement(acceptSavedFilter).click();
        return this;
    }

    public CatalogTileCardSaveFilter checkChoosenFilters(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(listOfManufacturers));
        driver.findElement(listOfManufacturers).click();
        assertEquals(true, driver.findElement(brandClick).isSelected(), "Неверно выбран бренд");
        scroller.executeScript("window.scrollBy(0,500)");
        driver.findElement(listOfViens).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(veinsClick));
        assertEquals(true, driver.findElement(veinsClick).isSelected(), "Неверно выбраны жилы");
//        assertEquals(true, driver.findElement(fromRus).isSelected(),
//                "Неверно выбрал фильтр \"Сделано в России\"");
        return this;
    }

}
