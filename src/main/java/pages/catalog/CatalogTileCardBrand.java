package pages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogTileCardBrand extends BasePage {
    public CatalogTileCardBrand(WebDriver driver) {
        super(driver);
    }

    By listOfManufacturers = By.xpath("//div[@id=\"panel1a-header\"]");

    public CatalogTileCardBrand openList() {
        driver.findElement(listOfManufacturers).click();
        return this;
    }

    public CatalogTileCardBrand checkExist(String brand) {
        List<String> listOfBrands = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            String manufName = driver.findElement(By.xpath("//*[@id=\"panel1a-content\"]/div/div/div[2]/div/p[" + i + "]")).getText();
            listOfBrands.add(manufName);
        }
        System.out.println(listOfBrands);

        boolean contains = listOfBrands.contains(brand);
        assertEquals(true, contains, "Бренды не совпадают");
        return this;
    }
}

