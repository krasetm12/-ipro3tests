package pages.IPROHome;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static constants.Constant.TimeOutVariables.EXPLICIT_WAIT;
import static constants.Constant.TimeOutVariables.IMPLICIT_WAIT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPROHomePage extends BasePage {

    public IPROHomePage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
    JavascriptExecutor scroller = (JavascriptExecutor) driver;

    By regButton = By.xpath("//button[@data-testid=\"authorization-button\"]");
    By inputLogin = By.xpath("//input[@name=\"login\"]");
    By inputPass = By.xpath("//input[@name=\"password\"]");
    By submitBtn = By.xpath("//button[@data-testid=\"go-to-system\"]");
    By allClear = By.xpath("//span[contains(.,'Все понятно')]");
    By allRight = By.xpath("//span[contains(.,'Все верно')]");
    By name = By.xpath("//*[@id=\"composition-button\"]/span[1]/div[2]/span");
    By nameIpro = By.xpath("//*[@id=\"composition-button\"]/span[1]/div[2]/span");


    public IPROHomePage enterAuthData(String login, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(allClear));
        wait.until(ExpectedConditions.visibilityOfElementLocated(allRight));
        driver.findElement(allClear).click();
        driver.findElement(allRight).click();
        driver.findElement(regButton).click();
        driver.findElement(inputLogin).clear();
        driver.findElement(inputLogin).sendKeys(login);
        driver.findElement(inputPass).clear();
        driver.findElement(inputPass).sendKeys(pass);
        return this;
    }

    public IPROHomePage clearAlerts() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(allClear));
        wait.until(ExpectedConditions.visibilityOfElementLocated(allRight));
        driver.findElement(allClear).click();
        driver.findElement(allRight).click();
        return this;
    }

    public IPROHomePage clickForLog() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn));
        driver.findElement(submitBtn).click();
        return this;
    }

    public IPROHomePage checkAuthComplete() {
        driver.manage().timeouts().implicitlyWait(EXPLICIT_WAIT, TimeUnit.SECONDS);
        String namePerson = driver.findElement(name).getText();
        assertEquals("Дегтярёв Никита Витальевич", namePerson);
        return this;
    }

    public IPROHomePage checkAuthIproComplete() {
        driver.manage().timeouts().implicitlyWait(EXPLICIT_WAIT, TimeUnit.SECONDS);
        String namePerson = driver.findElement(nameIpro).getText();
        assertEquals("Дегтярёв Никита Витальевич", namePerson);
        return this;
    }

}
