package pages.seoHTML;

import common.TakeInfoFromRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static common.CommonJobs.*;
import static constants.Constant.Urls.BROKEN_BRAND_PAGE;
import static constants.Constant.Urls.SEARCHING_PAGE_TD;
import static constants.Paths.nameBrand;


public class SearchSEO extends BasePage {

    public SearchSEO(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor scroller = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

    public SearchSEO findContentLowThenThree(String xpath, String nameOfTest) {
        getExistElement(By.xpath(xpath), nameOfTest);
        return this;
    }

    public SearchSEO findHttps(String xpath, String nameOfTest) {
        getExistElement(By.xpath(xpath), nameOfTest);
        return this;
    }

    public SearchSEO findAElements(String xpath, String nameOfTest, String mainXpath) throws InterruptedException {
        scroller.executeScript("window.scrollBy(0,2500)");
        Thread.sleep(500);
        driver.findElement(By.xpath(mainXpath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath + "[1]/div/div[2]/div/a")));
        int countOfEl = countElements(By.xpath(xpath));
        for (int i = 1; i <= countOfEl; i++) {
            getExistElement(By.xpath(xpath + "[" + i + "]/div/div[2]/div/a"), nameOfTest);
        }
        return this;
    }


    public SearchSEO findElementsInBrandPage(String xpath, String nameOfTest, String lastWords) {
        String val = driver.findElement(By.xpath(nameBrand)).getText();
        getExistElement(By.xpath(xpath + " " + val + lastWords.substring(1)), nameOfTest);
        return this;
    }


    public SearchSEO findFooterElements(String xpath, String nameOfTest) {
        scroller.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        int countOfEl = countElements(By.xpath(xpath));
        for (int i = 1; i <= countOfEl; i++) {
            String val = driver.findElement(By.xpath(xpath + "[" + i + "]")).getText();
            getExistElement(By.xpath(xpath + "[" + i + "]"), nameOfTest);
        }
        return this;
    }

    public SearchSEO checkIfChanged(String nameOfTest) {
        String url = driver.getCurrentUrl();
        System.out.println(url);
        comparingJob(url, BROKEN_BRAND_PAGE, nameOfTest);
        return this;
    }


    public SearchSEO findElementsInSearchPage(String xpath, String nameOfTest, String lastWords) {
        String val = SEARCHING_PAGE_TD.substring(SEARCHING_PAGE_TD.length() - 5);
        val = val.substring(0, 1).toUpperCase() + val.substring(1);
        getExistElement(By.xpath(xpath + val + lastWords.substring(1)), nameOfTest);
        return this;
    }


    public SearchSEO whenAddingCookie_thenItIsPresent() {
        logIn();
        return this;
    }

    public SearchSEO findElementsInCardPage(String xpath, String nameOfTest, String keys, String template, String urlForRequest) {
        getExistElement(By.xpath(String.format(template, formatedXParh(keys, urlForRequest, xpath))), nameOfTest);
        return this;
    }

}
