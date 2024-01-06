package tests.seoHTML;

import constants.Constant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.base.BaseTest;

import static constants.Constant.Urls.BROKEN_BRAND_PAGE;
import static constants.Paths.*;
import static constants.UrlsForRequestsAPI.urlCardForTestTitleFromRequest;

public class SearchInHTMLTest extends BaseTest {

    @DisplayName("Проврка на content=\"noindex, nofollow\" при выдаче < 3")
    @ParameterizedTest(name = "Тест №{index} -> Проврка на content=\"noindex, nofollow\" при выдаче < 3 -> {1}")
    @CsvSource(value = {content + ":noindex,nofollow"}, delimiter = ':')
    public void testHeader(String xpath, String nameOfTest) throws InterruptedException {
        basePage.open(Constant.Urls.BAD_PAGE_FOR_META);

        htmlPage
                .whenAddingCookie_thenItIsPresent()
                .findContentLowThenThree(xpath, nameOfTest);

    }

    @DisplayName("Проврка на https")
    @ParameterizedTest(name = "Тест №{index} -> Проврка на https -> {1}")
    @CsvSource(value = {
            canonicalHttps + ":В каталоге:catalog/101010_kabeli_s_mednoy_tokoprovodjaschey_zhiloy",
            canonicalHttps + ":В карточке товара:cat/nn/6427418",
            canonicalHttps + ":В бренде:brand/1787_kabeks",
            canonicalHttps + ":В поиске:catalog?searchValue=кабель",
    }, delimiter = ':')
    public void testHttps(String xpath, String nameOfTest, String url) {
        String bigUrl = Constant.Urls.IDEV_URL + url;
//        String lastXpath = bigUrl.replace(bigUrl.substring(bigUrl.length()-8), "") + "\']";
        basePage.open(bigUrl);

        htmlPage
                .findHttps(xpath + bigUrl + "\']", nameOfTest);

    }

    @DisplayName("Проврка на <a>")
    @ParameterizedTest(name = "Тест №{index} -> Проврка на <a> -> {1}")
    @CsvSource(value = {
            allInNewsAssortment + ":Новости ассортимента:" + newsAssortment,
            allInNewsIpro + ":Новости iPRO:" + newsIpro,
            allInNewsCompany + ":Новости компании:" + newsCompany,
            allInNewsReview + ":Статьи, обзоры:" + newsReview,
    }, delimiter = ':')
    public void testA(String xpath, String nameOfTest, String mainXpath) throws InterruptedException {
        basePage.open(Constant.Urls.IDEV_URL);

        htmlPage
                .findAElements(xpath, nameOfTest, mainXpath);

    }


    @DisplayName("Проврка на Title, Description, canonical")
    @ParameterizedTest(name = "Тест №{index} -> Проврка на Title, Description -> {1}")
    @CsvSource(value = {
            title + ";Title;. оптом и в розницу в интернет-магазине ЭТМ iPRO\"]",
            description + ";Description;.: информация о компании, товары, акции. Узнайте больше - в интернет-магазине ЭТМ iPRO']",
    }, delimiter = ';')
    public void testBrand(String xpath, String nameOfTest, String lastWords) {
        basePage.open(Constant.Urls.BRAND_PAGE_FOR_TDC);

        htmlPage
                .findElementsInBrandPage(xpath, nameOfTest, lastWords);

    }


    @DisplayName("Проврка на <a> в футере")
    @ParameterizedTest(name = "Тест №{index} -> Проврка на <a> в футере -> {1}")
    @CsvSource(value = {
            footerCatalog + ":<a> в футере",
    }, delimiter = ':')
    public void testA(String xpath, String nameOfTest) {
        basePage.open(Constant.Urls.IDEV_URL);

        htmlPage
                .findFooterElements(xpath, nameOfTest);

    }


    @DisplayName("Проврка на редирект урла для бренда")
    @ParameterizedTest(name = "Тест №{index} -> Проврка на <a> в футере -> {1}")
    @CsvSource(value = {
            BROKEN_BRAND_PAGE + ":url новый",
    }, delimiter = ':')
    public void testBrokenBrandPage(String nameOfTest) {
        basePage.open(BROKEN_BRAND_PAGE);

        htmlPage
                .checkIfChanged(nameOfTest);

    }


    @DisplayName("Проврка на редирект урла для бренда")
    @ParameterizedTest(name = "Тест №{index} -> Проврка на <a> в футере -> {1}")
    @CsvSource(value = {
            titleSearch + ";Title;. купить оптом и в розницу в интернет-магазине ЭТМ iPRO']",
            descriptionSearch + ";Description;. - купить в интернет-магазине ЭТМ по выгодным ценам," +
                    " широкий каталог продукции и ассортимент для юридических и физических лиц, фото" +
                    " и характеристики, условия доставки. Интернет-каталог ЭТМ iPRO.']",
    }, delimiter = ';')
    public void testSearchingTD(String xpath, String nameOfTest, String lastWords) {
        basePage.open(Constant.Urls.SEARCHING_PAGE_TD);

        htmlPage
                .findElementsInSearchPage(xpath, nameOfTest, lastWords);

    }


    @DisplayName("Дополнение к формированию title артикул")
    @ParameterizedTest(name = "Тест №{index} -> Дополнение к формированию title артикул -> {1}")
    @CsvSource(value = {
            titleArticleNumber + ";Дополнение к формированию title артикул;gdsNameTitle, gdsArt, gdsMnfName;%s %s артикул %s %s | Интернет-магазин ЭТМ iPRO'];"
                    + urlCardForTestTitleFromRequest,
    }, delimiter = ';')
    public void testTitleFromRequest(String xpath, String nameOfTest, String keys, String template, String urlForRequest) {
        basePage.open(Constant.Urls.PRODUCT_PAGE);

        htmlPage
                .findElementsInCardPage(xpath, nameOfTest, keys, template, urlForRequest);

    }
}