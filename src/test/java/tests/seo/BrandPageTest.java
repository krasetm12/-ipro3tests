package tests.seo;

import constants.Constant;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.base.BaseTest;

import static constants.Paths.*;
public class BrandPageTest extends BaseTest {
    @DisplayName("Бренды")
    @ParameterizedTest(name = "Тест №{index} -> Проверка на существование в DOM блоков -> {1}")
    @CsvSource({
            filters + "," + "Фильтры",
            famousProsucts + "," + "Популярные товары",
            actions + "," + "Акции",
    })
    public void cardPagePaymentAndDeliveryTest(String xpath, String nameOfTest) {
        basePage.open(Constant.Urls.BRAND_PAGE);
        brandPage
                .checkNumExist(xpath, nameOfTest)
        ;

    }

    @DisplayName("Проврка на существование в DOM блоков: новости, акции")
    @ParameterizedTest(name = "Тест №{index} -> Проврка на существование в DOM блоков -> {1}")
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
        basePage.open(Constant.Urls.BRAND_PAGE);

        Thread.sleep(3000);

        headerSEO
                .headerNewsAndAction(xpath, nameOfTest);
    }
}
