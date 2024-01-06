package pages.seo;

import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

import static common.CommonJobs.getExistElement;
import static common.CommonJobs.getExistElementByQuantity;
public class BrandPageSEO extends BasePage {
    public BrandPageSEO(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor scroller = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    public BrandPageSEO checkNumExist(String xpath, String nameOfTest) {
        getExistElementByQuantity(By.xpath(xpath), nameOfTest);
        return this;
    }

}
