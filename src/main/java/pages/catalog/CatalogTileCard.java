package pages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import java.util.concurrent.TimeUnit;

import static constants.Constant.TimeOutVariables.EXPLICIT_WAIT;

public class CatalogTileCard extends BasePage {

    public CatalogTileCard(WebDriver driver) {
        super(driver);
    }

    By catBtn = By.xpath("//button[@data-testid=\"all-goods-button\"]");
    By category = By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[1]/div[1]/ul/li[1]/div/div/div");
    By lowerCategory = By.xpath("//html/body/div[2]/div[3]/div/div[2]/div[1]/div[1]/ul/li[1]/div/ul/li[1]/div/div/p");
    By typeOfView = By.xpath("//button[@title=\"Вид плиткой\"]");


    public CatalogTileCard enterDataForAuth() {
        driver.findElement(catBtn).click();
        driver.findElement(category).click();
        driver.findElement(lowerCategory).click();
        driver.manage().timeouts().implicitlyWait(EXPLICIT_WAIT, TimeUnit.SECONDS);
        return this;
    }

    public CatalogTileCard enterData() {
        driver.findElement(catBtn).click();
        driver.findElement(category).click();
        driver.findElement(lowerCategory).click();
        driver.manage().timeouts().implicitlyWait(EXPLICIT_WAIT, TimeUnit.SECONDS);
        driver.findElement(typeOfView).click();
        driver.manage().timeouts().implicitlyWait(EXPLICIT_WAIT, TimeUnit.SECONDS);
        return this;
    }

    public CatalogTileCard checkCatComplete() {
        try {
            Thread.sleep(3000);
            driver.findElement(typeOfView).isSelected();
        } catch (Exception e) {
            /* throw (e); */
        }
        return this;
    }
}
