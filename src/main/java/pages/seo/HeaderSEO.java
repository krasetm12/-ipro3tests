package pages.seo;

import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static common.CommonJobs.getExistElement;
import static common.CommonJobs.getExistElementByQuantity;
import static constants.Constant.TimeOutVariables.EXPLICIT_WAIT;
import static constants.Constant.TimeOutVariables.IMPLICIT_WAIT;
import static constants.Paths.checkLoad;
import static constants.Paths.enterButton;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class HeaderSEO extends BasePage {
    public HeaderSEO(WebDriver driver) {super(driver);}
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
    JavascriptExecutor scroller = (JavascriptExecutor) driver;

    boolean exist;


    public HeaderSEO headerNewsAndAction(String xpath, String nameOfTest){
        scroller.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        getExistElement(By.xpath(xpath), nameOfTest);
        return this;
    }

    public HeaderSEO actions(String xpath, String nameOfTest) throws InterruptedException {
//        Thread.sleep(3000);
        scroller.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        getExistElement(By.xpath(xpath), nameOfTest);
        return this;
    }

}
