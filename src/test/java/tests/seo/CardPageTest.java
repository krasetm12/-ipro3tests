package tests.seo;

import constants.Constant;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.base.BaseTest;

import static constants.Paths.*;

public class CardPageTest extends BaseTest {
    @DisplayName("Проврка на существование в DOM блоков: Оплата и  Доставка")
    @ParameterizedTest(name = "Тест №{index} -> Проверка на существование в DOM блоков -> {1}")
    @CsvSource({
//            deliveryTable + "," + "Способы получения" + "," + "631301",
            paymentTable + "," + "Оплата" + "," + "631301",
            certificates + "," + "Сертификаты" + "," + "631301",
            dontForget + "," + "Не забудьте купить" + "," + "631301",
            allVariants + "," + "Все варианты товара" + "," + "8314493",
    })
    public void cardPagePaymentAndDeliveryTest(String xpath, String nameOfTest, String product) {
        basePage.open(Constant.Urls.CARD_PAGE+product);
        cardPage
                .checkPaymentDeliveryCertificates(xpath, nameOfTest)
                ;
    }

    @DisplayName("Проврка на существование в DOM блоков: Характеристики ")
    @ParameterizedTest(name = "Тест №{index} -> Проврка на существование в DOM блоков -> {1}")
    @CsvSource({
            specificationsTableOne + "," + "Характеристики 1 под фото" + "," + "631301",
            specificationsTableTwo + "," + "Характеристики 2 под фото" + "," + "631301",
            specificationsTableThree + "," + "Характеристики основные" + "," + "631301",
    })
    public void cardPageSpecificationsTest(String xpath, String nameOfTest, String product) {
        basePage.open(Constant.Urls.CARD_PAGE+product);
        cardPage
                .checkSpecifications(xpath, nameOfTest)
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
