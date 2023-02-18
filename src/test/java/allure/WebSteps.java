package allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    final static String URL = "https://github.com/selenide/selenide";
    final static String ISSUE = "2145";
    final static String TEXT = "use CDP screencast API to record mp4 videos - extremely useful for headless mode";
    @Step("переходим на страницу Селенида " + URL)
    public void openPage(){
        open(URL);
    }
    @Step("кликаем по кнопке Issue")
    public void issueTabClick(){
        $("#issues-tab").click();
    }
    @Step("ищем через поисковик статью под номером " + ISSUE)
    public void searchForIssue(){
        $("#js-issues-search").click();
        $("#js-issues-search").setValue(ISSUE);
        $("#js-issues-search").pressEnter();
    }
    @Step("Статья " + ISSUE + " имеет название " + TEXT)
    public void checkTheTitleOfIssue(){
        $("#issue_2145").shouldHave(text
                (TEXT));
    }
}




