package tests.catalog;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.base.BaseTest;

import static constants.Constant.*;
import static constants.Constant.PASSWORD_IPRO;

public class TileCartTest extends BaseTest {
    @Test
    @DisplayName("Тест аворизации пользователя MARKET и переход на вид плиткой")
    @ParameterizedTest
    @CsvSource({
            LOGIN_MARKET + "," + PASSWORD_MARKET,
            LOGIN_IPRO + "," + PASSWORD_IPRO,
            "1,1"
        })
    public void checkTileCart(String login, String pass) {

        basePage.open(Urls.PROD_HOME_PAGE);

        if (!login.equals("1")) {
            iproHomePage
                    .enterAuthData(login, pass)
                    .clickForLog()
                    .checkAuthComplete();
            catalogTileCard
                    .enterData()
                    .checkCatComplete();
        } else {
            iproHomePage
                    .clearAlerts();
            catalogTileCard
//                    .enterDataForNoAuth()
                    .checkCatComplete();
        }
    }


}
