package tests.catalog;

import constants.Constant;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.base.BaseTest;

import static constants.Constant.*;
import static constants.Constant.BRAND;

@Disabled("Disabled until bug #2019 has been fixed!")
public class TileCartCategoryTest extends BaseTest {

    @Test
    @DisplayName("Тест на наличие категорий и их совпадний")
    @ParameterizedTest
    @CsvSource({
            LOGIN_MARKET + "," + PASSWORD_MARKET,
            LOGIN_IPRO + "," + PASSWORD_IPRO,
            "1,1"})
    public void checkTileCartCategory(String login, String pass) {

        basePage.open(Constant.Urls.PROD_HOME_PAGE);

        if (!login.equals("1")) {
            iproHomePage
                    .enterAuthData(login, pass)
                    .clickForLog()
                    .checkAuthComplete();
            catalogTileCard
                    .enterData()
                    .checkCatComplete();
            catalogTileCardCategory
                    .compareNames();
        } else {
            iproHomePage
                    .clearAlerts();
            catalogTileCard
//                    .enterDataForNoAuth()
                    .checkCatComplete();
            catalogTileCardCategory
                    .compareNames();
        }
    }
}
