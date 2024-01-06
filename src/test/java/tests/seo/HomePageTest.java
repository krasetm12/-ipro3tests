package tests.seo;

import constants.Constant;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.base.BaseTest;

import static constants.Constant.*;
import static constants.Constant.PASSWORD_IPRO;
import static constants.Paths.*;

public class HomePageTest extends BaseTest {
    @DisplayName("Проврка на существование на главной в DOM блоков: новости, акции")
    @ParameterizedTest(name = "Тест №{index} -> Проверка на существование в DOM блоков -> {1}")
    @CsvSource({
            newsA + "," + "Новости ассортимента",
            iproNewsA + "," + "Новости iPRO",
            companyA + "," + "Новости компании",
            articlesA + "," + "Статьи обзоры",
            libraryA + "," + "Техбиблиотека",
            actionsA + "," + "Акции",
            loyaltyA + "," + "Программа лояльности",
    })
    public void testHeader(String xpath, String nameOfTest) throws InterruptedException {
        Thread.sleep(3000);
        basePage.open(Constant.Urls.IDEV_HOME_PAGE);


        headerSEO
                .headerNewsAndAction(xpath, nameOfTest);
    }

    @DisplayName("Проврка на существование на главной в DOM блоков")
    @ParameterizedTest(name = "Тест №{index} -> Проврка на существование в DOM блоков -> {1}")
    @CsvSource({
            categoryTable + "," + "Категории",
            hitsTable + "," + "Хиты продаж",
            advantagesTable + "," + "Преимущества работы с ЭТМ",
            actionsTable + "," + "Больше выгоды",
            assortmentTable + "," + "Развитие ассортимента",
            newsTable + "," + "Новости",
            h1Text + "," + "ЭТМ - комплексный поставщик инженерных систем",
    })
    public void testMainPage(String xpath, String nameOfTest) throws InterruptedException {
        basePage.open(Constant.Urls.IDEV_HOME_PAGE);

        Thread.sleep(3000);

        mainPage
                .h1TextOnPage(xpath, nameOfTest)
                .category(xpath, nameOfTest)
                .hits(xpath, nameOfTest)
                .advantagesCheck(xpath, nameOfTest)
                .actionsCheck(xpath, nameOfTest)
                .assortmentCheck(xpath, nameOfTest)
                .newsCheck(xpath, nameOfTest);

    }


}
