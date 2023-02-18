package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWithListener {
    final static String URL = "https://github.com/selenide/selenide";
    final static String ISSUE = "2145";
    final static String TEXT = "use CDP screencast API to record mp4 videos - extremely useful for headless mode";
    @Test
    @Owner("nfrolova")
    @DisplayName("Чистый Selenide с Listener")
    public void checkIssueName(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(URL);
        $("#issues-tab").click();
        $("#js-issues-search").click();
        $("#js-issues-search").setValue(ISSUE);
        $("#js-issues-search").pressEnter();
        $("#issue_2145").shouldHave(text
                        (TEXT));
    }
}
