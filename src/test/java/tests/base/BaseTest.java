package tests.base;

import common.CommonActions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import pages.resitration.RegIPRO;
import pages.IPROHome.IPROHomePage;
import pages.base.BasePage;
import pages.catalog.*;
import pages.seo.*;
import pages.seoHTML.SearchSEO;


//import static common.Config.BROWSER_AND_PLATFORM;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static common.Config.HOLD_BROWSER_OPEN;
import static constants.Constant.TimeOutVariables.IMPLICIT_WAIT;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected IPROHomePage iproHomePage = new IPROHomePage(driver);
    protected CatalogTileCard catalogTileCard = new CatalogTileCard(driver);
    protected CatalogTileCardSearch catalogTileCartSearch = new CatalogTileCardSearch(driver);
    protected CatalogTileCardBrand catalogTileCartBrand = new CatalogTileCardBrand(driver);
    protected CatalogTileCardCategory catalogTileCardCategory = new CatalogTileCardCategory(driver);
    protected CatalogTileCardSaveFilter catalogTileCardSaveFilter = new CatalogTileCardSaveFilter(driver);
    protected RegIPRO regIPRO = new RegIPRO(driver);
    protected HeaderSEO headerSEO = new HeaderSEO(driver);
    protected MainPageSEO mainPage = new MainPageSEO(driver);

    protected CatalogPageSEO catalogPage = new CatalogPageSEO(driver);
    protected BrandPageSEO brandPage = new BrandPageSEO(driver);

    protected CardPageSEO cardPage = new CardPageSEO(driver);
    protected TagsPageSEO tagsPage = new TagsPageSEO(driver);

    protected SearchSEO htmlPage = new SearchSEO(driver);

    @BeforeEach
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @AfterEach
    public void close() {
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        if (HOLD_BROWSER_OPEN) {
            driver.manage().deleteAllCookies();
            driver.close();
            driver.quit();
        }
    }
}
