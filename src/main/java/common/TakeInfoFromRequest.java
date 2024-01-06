package common;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import lib.BaseTestCase;

import java.util.ArrayList;
import java.util.List;

import static constants.UrlsForRequestsAPI.urlCardForTestTitleFromRequest;
import static io.restassured.RestAssured.given;

public class TakeInfoFromRequest extends BaseTestCase {

    public String sessionIdImport() {
        String sessionId;
        /*
         * Авторизация и сохранение куки
         * */
        Response responseGetAuth = given()
                .filter(new AllureRestAssured())
                .post("https://idev.etm.ru/api/ipro/user/login?log=9692161158&pwd=20101999d")
                .andReturn();
        sessionId = getSingleHeaderFromJson(responseGetAuth, "data", ".session");
        return sessionId;
    }

    /*
    * Метод берет данные 1 уровня из запроса
    * */
    public List<String> takeInfoFstGrade(List<String> listOfKeys, String urlCardForTestTitleFromRequest) {
        List<String> listOfVal = new ArrayList<>();
        for (int i = 0; i <= listOfKeys.size() - 1; i++) {
            Response responseGetAuth = given()
                    .filter(new AllureRestAssured())
                    .get(urlCardForTestTitleFromRequest)
                    .andReturn();
            listOfVal.add(getSingleHeaderFromJson(responseGetAuth, "data", "." + listOfKeys.get(i)));
        }
        return listOfVal;
    }
}
