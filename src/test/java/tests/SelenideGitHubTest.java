package tests;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideGitHubTest {

    String
            repositoryWay = "maksimdemsky/homework1",
            issueNumber = "#1";

    public void SearchGitHubTest() {

        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repositoryWay);
        $(".header-search-input").submit();
        $(By.linkText(repositoryWay)).click();
        $(withText("Issues")).click();
        $(withText(issueNumber)).should(Condition.exist);
    }
}
