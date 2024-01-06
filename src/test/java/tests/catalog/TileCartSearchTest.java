package tests.catalog;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.base.BaseTest;

import static constants.Constant.*;
import static constants.Constant.PASSWORD_IPRO;

//@Disabled("Disabled until bug #2019 has been fixed!")
public class TileCartSearchTest extends BaseTest {

    @Test
    @DisplayName("Работы поиска в катлоге в вид плиткой")
    @ParameterizedTest
    @CsvSource({
            LOGIN_MARKET + "," + PASSWORD_MARKET,
            LOGIN_IPRO + "," + PASSWORD_IPRO,
            "1,1"})
    public void checkSearch(String login, String pass) {

        basePage.open(Urls.PROD_HOME_PAGE);

        if (!login.equals("1")) {
            iproHomePage
                    .enterAuthData(login, pass)
                    .clickForLog()
                    .checkAuthComplete();
            catalogTileCard
                    .enterData()
                    .checkCatComplete();
            catalogTileCartSearch
                    .inputData()
                    .clickSearch()
                    .checkResult();
        } else {
            iproHomePage
                    .clearAlerts();
            catalogTileCard
//                    .enterDataForNoAuth()
                    .checkCatComplete();
            catalogTileCartSearch
                    .inputData()
                    .clickSearch()
                    .checkResult();

        }
    }

}
