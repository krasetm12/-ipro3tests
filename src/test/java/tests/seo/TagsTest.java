package tests.seo;

import constants.Constant;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.base.BaseTest;

import static constants.Paths.CARDS_TABLE;

public class TagsTest extends BaseTest {
    @DisplayName("Проврка на существование в DOM блоков: тэги")
    @ParameterizedTest(name = "Тест №{index} -> Проверка на существование в DOM блоков -> {1}")
//    @CsvSource(delimiter = '|', textBlock = """
//                    CARDS_TABLE|    Проверка карточек товара на странице тега
//            """)
    @CsvSource({
                    CARDS_TABLE + "," + "Проверка карточек товара на странице тега",
})
    public void tags(String xpath, String nameOfTest) {
        basePage.open(Constant.Urls.TAG_PAGE);
        tagsPage
                .checkExistCards(xpath, nameOfTest);
    }
}
