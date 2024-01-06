package tests.seo;

import constants.Constant;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.base.BaseTest;

import static constants.Paths.*;

public class CatalogPageTest extends BaseTest {
    @DisplayName("Проврка на существование в DOM блоков: новости, акции")
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
        basePage.open(Constant.Urls.CATALOG_PAGE);

        headerSEO
                .headerNewsAndAction(xpath, nameOfTest);
    }

    @DisplayName("Проврка на существование в DOM блоков: категории")
    @ParameterizedTest(name = "Тест №{index} -> Проврка на существование в DOM блоков -> {1}")
    @CsvSource({
            category + "," + "Категории",
    })
    public void testCatalogCategory(String xpath, String nameOfTest) throws InterruptedException {
        basePage.open(Constant.Urls.CATALOG_PAGE);


        catalogPage
                .checkExist(xpath, nameOfTest);
    }
    @DisplayName("Проврка на существование в DOM блоков: карточки товара")
    @ParameterizedTest(name = "Тест №{index} -> Проврка на существование в DOM блоков -> {1}")
    @CsvSource({
            cardsTableCatalog + "," + "Карточки",
    })
    public void testCatalogCard(String xpath, String nameOfTest) throws InterruptedException {
        basePage.open(Constant.Urls.CATALOG_PAGE);

        catalogPage
                .checkNumExist(xpath, nameOfTest);
    }
}
