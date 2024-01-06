package pages.seo;

import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import static common.CommonJobs.getExistElementByQuantity;
public class TagsPageSEO extends BasePage {
    public TagsPageSEO(WebDriver driver) {
        super(driver);
    }

    public TagsPageSEO checkExistCards(String xpath, String nameOfTest) {
        getExistElementByQuantity(By.xpath(xpath), nameOfTest);
        return this;
    }
}
