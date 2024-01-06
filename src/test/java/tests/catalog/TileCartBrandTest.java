package tests.catalog;

import constants.Constant;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base.BaseTest;

import static constants.Constant.*;
@Disabled("Disabled until bug #2019 has been fixed!")
public class TileCartBrandTest extends BaseTest {
    @Test
    @DisplayName("Тест на наличие брендов")
    @ParameterizedTest
    @CsvSource({
            LOGIN_MARKET + "," + PASSWORD_MARKET  + "," +  BRAND,
            LOGIN_IPRO + "," + PASSWORD_IPRO  + "," +  BRAND,
            "1,1," + BRAND})
    public void checkTileCartBrand(String login, String pass, String brand) {

        basePage.open(Constant.Urls.PROD_HOME_PAGE);

        if (!login.equals("1")) {
            iproHomePage
                    .enterAuthData(login, pass)
                    .clickForLog()
                    .checkAuthComplete();
            catalogTileCard
                    .enterData()
                    .checkCatComplete();
            catalogTileCartBrand
                    .openList()
                    .checkExist(brand);
        } else {
            iproHomePage
                    .clearAlerts();
            catalogTileCard
//                    .enterDataForNoAuth()
                    .checkCatComplete();
            catalogTileCartBrand
                    .openList()
                    .checkExist(brand);
        }
    }
}
