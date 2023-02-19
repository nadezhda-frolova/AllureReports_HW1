package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AllureWithAnnotationStep {
    @Test
    @Owner("nfrolova")
    @DisplayName("Шаги с аннотацией @Step")
    public void checkIssueName() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openPage();
        steps.issueTabClick();
        steps.searchForIssue();
        steps.checkTheTitleOfIssue();
    }
}
