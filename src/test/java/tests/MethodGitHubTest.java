package tests;

import org.junit.jupiter.api.Test;
import steps.BaseSteps;

public class MethodGitHubTest {


    public BaseSteps steps = new BaseSteps();
    @Test
    public void testIssueSearch() {
        steps.openMainPage();
        steps.searchRepository();
        steps.openRepositiry();
        steps.openIssueInRepository();
        steps.checkIssueNumber();

    }

}
