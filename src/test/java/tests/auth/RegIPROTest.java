package tests.auth;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.base.BaseTest;
import javax.mail.MessagingException;
import java.io.IOException;

import static constants.Constant.*;


public class RegIPROTest extends BaseTest {

    @DisplayName("Registration iPRO")
    @ParameterizedTest(name = "Тест №{index} -> Проврка на существование в DOM блоков -> {1}")
    @CsvSource({
            EMAIL
            })
//    @Test
    public void checkAuthIPRO(String email) throws MessagingException, IOException, InterruptedException {
        basePage.open(Urls.IDEV_HOME_PAGE);

        regIPRO
                .firstStepEmail(email)
                .firstStepCode(email);
    }
}
