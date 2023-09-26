import Hooks.webHooks;
import org.junit.jupiter.api.Test;
import static steps.authPageSteps.*;
import static steps.mainPageSteps.*;
import static steps.singleTaskPageSteps.*;
import static steps.tasksPageSteps.*;

public class cssXpathTest extends webHooks {
    @Test
    public void jiraTest() {
        chromeTest();
        loginFunc(loginInputParam, passwordInputParam);
        goToRequiredProject();
        showAmountOfCompletedTasks();
        search(searchInputParam);
        taskCheck();
        createTask(issueTypeParam,
                   issueValueParam,
                   versionFieldParam,
                   priorityFieldParam,
                   labelSelectTestParam,
                   descriptionAreaParam,
                   testEnvironmentAreaParam);
        completeTask(searchSortTestParam,
                     searchFilterTestParam,
                     taskStatusCheckDoneParam,
                     taskStatusCheckInWorkParam,
                     taskStatusCheckReopenParam,
                     taskStatusCheckFinishedParam,
                     taskStatusCheckFinished2Param);
    }


}
