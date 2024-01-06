package pages.seo;

import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

import static common.CommonJobs.getExistElement;
import static constants.Constant.EXIST;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageSEO extends BasePage {
    public MainPageSEO(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor scroller = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    public MainPageSEO h1TextOnPage(String xpath, String nameOfTest) {
        getExistElement(By.xpath(xpath), nameOfTest);
        return this;
    }

    public MainPageSEO category(String xpath, String nameOfTest) {
        getExistElement(By.xpath(xpath), nameOfTest);
        return this;
    }

    public MainPageSEO hits(String xpath, String nameOfTest) throws InterruptedException {
        getExistElement(By.xpath(xpath), nameOfTest);
        return this;
    }

    public MainPageSEO advantagesCheck(String xpath, String nameOfTest) throws InterruptedException {
        getExistElement(By.xpath(xpath), nameOfTest);
        return this;
    }

    public MainPageSEO actionsCheck(String xpath, String nameOfTest) throws InterruptedException {
        getExistElement(By.xpath(xpath), nameOfTest);
        return this;
    }

    public MainPageSEO assortmentCheck(String xpath, String nameOfTest) throws InterruptedException {
        getExistElement(By.xpath(xpath), nameOfTest);
        return this;
    }

    public MainPageSEO newsCheck(String xpath, String nameOfTest) throws InterruptedException {
        getExistElement(By.xpath(xpath), nameOfTest);
        return this;
    }
}

