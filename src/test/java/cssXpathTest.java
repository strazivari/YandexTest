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
        loginFunc();
        goToRequiredProject();
        showAmountOfCompletedTasks();
        search();
        taskCheck();
        createTask();
        completeTask();
    }


}
