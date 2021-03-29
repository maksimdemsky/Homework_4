package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    String base_url = "https://github.com/",
            repositoryWay = "maksimdemsky/homework1",
            issueNumber = "#1";

    @Step("Открываем главную страницу Гитхаб")
    public void openMainPage() {
        open(base_url);
    }

    @Step("Вводим {repositoryWay} в строку поиска")
    public void searchRepository() {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repositoryWay);
        $(".header-search-input").submit();
    }

    @Step("Открываем репозиторий {repositoryWay}")
    public void openRepositiry() {
        $(By.linkText(repositoryWay)).click();
    }

    @Step("Открываем вкладку {Issues}")
    public void openIssueInRepository() {
        $(withText("Issues")).click();

    }

    @Step("Проверяем что Issue с номером {issueNumber} существует")
    public void checkIssueNumber() {
        $(withText(issueNumber)).should(Condition.exist);
    }
}
