package tests.authmarket;

import constants.Constant;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.base.BaseTest;
import org.junit.jupiter.api.DisplayName;

import static constants.Constant.*;

@Disabled("Disabled until bug #2019 has been fixed!")
public class AuthMarketTest extends BaseTest {

    @DisplayName("Тест аворизации пользователей")
    @ParameterizedTest
    @CsvSource({LOGIN_MARKET + "," + PASSWORD_MARKET,
                        LOGIN_IPRO + "," + PASSWORD_IPRO})
    public void checkIsAuthCompite(String login, String pass){
        basePage.open(Constant.Urls.PROD_HOME_PAGE);
        iproHomePage
                .enterAuthData(login, pass)
                .clickForLog()
                .checkAuthComplete();
    }
}
