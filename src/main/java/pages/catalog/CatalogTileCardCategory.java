package pages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogTileCardCategory extends BasePage {

    public CatalogTileCardCategory(WebDriver driver) {
        super(driver);
    }

    By catName = By.xpath("//div[text()=\"Кабели силовые с медной жилой для стационарной прокладки\"]");
    By catInBreadcrumb = By.xpath("//a[text()=\"Кабели силовые с медной жилой для стационарной прокладки\"]");
    By catNameParent = By.xpath("//div[text()=\"Кабели с медной токопроводящей жилой\"]");
    By catInBreadcrumbParent = By.xpath("//a[text()=\"Кабели с медной токопроводящей жилой\"]");

    public CatalogTileCardCategory compareNames(){
        String valueOfCatName= driver.findElement(catName).getText();
        String valueOfCatInBreadcrumb= driver.findElement(catInBreadcrumb).getText();
        String valueOfCatNameParent= driver.findElement(catNameParent).getText();
        String valueOfCatInBreadcrumbParent= driver.findElement(catInBreadcrumbParent).getText();
        assertEquals(valueOfCatName, valueOfCatInBreadcrumb, "Категории не совпадают");
        assertEquals(valueOfCatNameParent, valueOfCatInBreadcrumbParent, "Родительсие категории не совпадают");
        return this;
    }

}
