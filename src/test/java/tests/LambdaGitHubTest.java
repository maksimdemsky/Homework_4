package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import jdk.jfr.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaGitHubTest {
    String
            repositoryWay = "maksimdemsky/homework1",
            issueNumber = "#1",
            base_url = "https://github.com/";

    @Test
    @Name("Поиск Issue по номеру в Гитхаб репозитории")
    @Owner("Maksim Demsky")
    @Tag("Web tests")
    @Link("https://github.com/")
    @Feature("Issue")
    @DisplayName("Поиск по Issue")
    @Severity(SeverityLevel.BLOCKER)
    public void SearchGitHubTest() {

        step("Открываем главную страницу Гитхаб", () -> {
            open(base_url);
        });
        step("Вводим в строку поиска" + repositoryWay, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(repositoryWay);
            $(".header-search-input").submit();
        });

        step("Открываем репозиторий" + repositoryWay, () -> {
            $(By.linkText(repositoryWay)).click();
        });

        step("Открываем Issue и проверяем что " + issueNumber + " существуют", () -> {
            $(withText("Issues")).click();
            $(withText(issueNumber)).should(Condition.exist);
        });


    }
}
