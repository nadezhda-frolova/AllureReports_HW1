package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AllureWithLambda {
    final static String URL = "https://github.com/selenide/selenide";
    final static String ISSUE = "2145";
    final static String TEXT = "use CDP screencast API to record mp4 videos - extremely useful for headless mode";
    @Test
    @Owner("nfrolova")
    @DisplayName("Лямбда шаги через step")
    public void checkIssueName(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("переходим на страницу Селенида " + URL, ()-> {
                    open(URL);
                });
        step("кликаем по кнопке Issue", ()-> {
            $("#issues-tab").click();
        });
        step("ищем через поисковик статью под номером " + ISSUE, ()-> {
            $("#js-issues-search").click();
            $("#js-issues-search").setValue(ISSUE);
            $("#js-issues-search").pressEnter();
        });
        step("Статья " + ISSUE + " имеет название " + TEXT, ()-> {
            $("#issue_2145").shouldHave(text
                    (TEXT));
        });
}
}
