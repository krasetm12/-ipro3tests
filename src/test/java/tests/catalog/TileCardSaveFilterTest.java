package tests.catalog;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.base.BaseTest;

import static constants.Constant.*;
@Disabled("Disabled until bug #2019 has been fixed!")
public class TileCardSaveFilterTest extends BaseTest {

    @Test
    @DisplayName("Тест сохранения фильтров")
    @ParameterizedTest
    @CsvSource({
            LOGIN_MARKET + "," + PASSWORD_MARKET,
            LOGIN_IPRO + "," + PASSWORD_IPRO
    })
    public void checkSearch(String login, String pass) {


        basePage.open(Urls.PROD_HOME_PAGE);

        iproHomePage
                .enterAuthData(login, pass)
                .clickForLog();
//                .checkAuthComplete();
        catalogTileCard
                .enterData()
                .checkCatComplete();
        catalogTileCardSaveFilter
                .brandChoose()
                .veinsChoose();
//                .fromRusChoose();
        basePage
                .waiter();
        catalogTileCardSaveFilter
                .enterAllFilters()
                .saveAllFilters()
                .chooseSavedFilter()
                .checkChoosenFilters();


    }
}

