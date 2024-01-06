package common;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static constants.Constant.EXIST;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonJobs extends BasePage {

    public CommonJobs(WebDriver driver) {
        super(driver);
    }
    static TakeInfoFromRequest apiWorker = new TakeInfoFromRequest();

    public static void getExistElementByQuantity(By xpath, String nameOfTest) {
        int numOfEl = driver.findElements(xpath).size();
        EXIST = numOfEl > 1 ? true : false;
        assertEquals(true, EXIST, "Нехватает элементов в -> " + nameOfTest);
    }

    public static void getExistElement(By xpath, String nameOfTest) {
        EXIST = !driver.findElements(xpath).isEmpty();
        assertEquals(true, EXIST, "Нет " + nameOfTest + " в DOM");
    }

    public static int countElements(By xpath) {
        int countOfEl = driver.findElements(xpath).size();
        return countOfEl;
    }

    public static void comparingJob(String expectedUrl, String url, String nameOfTest) {
        assertEquals(expectedUrl, url.substring(0, url.length() - 5), "Нет " + nameOfTest + " в DOM");

    }


    public static void logIn() {
        Cookie cookie = new Cookie("session-id", apiWorker.sessionIdImport());
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }

    /*
    * Метод формирования xPath для поиска
    * */
    public static Object[] formatedXParh (String keys, String urlForRequest, String xpath) {
        List<String> listOfKeys = new ArrayList<>(Arrays.asList(keys.split(",")));
        List<String> ADS = apiWorker.takeInfoFstGrade(listOfKeys, urlForRequest);
        ADS.add(0, xpath);
        Object[] array = new Object[]{};
        for (int i = 0; i <= ADS.size() - 1; i++) {
            array = ADS.toArray(new Object[i]);
        }
        return array;
    }

}