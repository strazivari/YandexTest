package Steps;

import elements.TasksPageElements;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.sleep;

public class TasksPageSteps extends TasksPageElements {
    @Step("Провека количества задач в проекте")
    public static void showAmountOfCompletedTasks() {
        tasksPage.click();
        String text = completedTasks.getText();
        String[] words = text.split(" ");
        System.out.println("Количество задач в проекте:" + words[2]);

    }

    public static void search(String searchInputParam) {
        searchInput.setValue(searchInputParam);
        firstSearchResult.click();
    }

    public static void completeTask(String searchSortTestParam,
                                    String searchFilterTestParam,
                                    String taskStatusCheckDoneParam,
                                    String taskStatusCheckInWorkParam,
                                    String taskStatusCheckReopenParam,
                                    String taskStatusCheckFinishedParam,
                                    String taskStatusCheckFinished2Param) {

        searchFilter.click();
        myOpenedTasks.click();
        Assertions.assertEquals(searchFilterTest.getText(), searchFilterTestParam);

        filterActivation.click();
        filterByDate.click();
        sleep(2000);
        Assertions.assertEquals(searchSortTest.getText(), searchSortTestParam);

        lastTask.click();

        inProgressTask.click();
        sleep(2000);
        Assertions.assertEquals(taskStatusCheck.getText(), taskStatusCheckInWorkParam);

        businessProcessTask.click();
        executedTask.click();
        submitButtonTask.click();
        sleep(2000);
        Assertions.assertEquals(taskStatusCheck.getText(), taskStatusCheckDoneParam);

        businessProcessTask.click();
        reopenedTask.click();
        submitButtonTask.click();
        sleep(2000);
        Assertions.assertEquals(taskStatusCheck.getText(), taskStatusCheckReopenParam);

        businessProcessTask.click();
        inWorkTask.click();
        sleep(2000);
        Assertions.assertEquals(taskStatusCheck.getText(), taskStatusCheckInWorkParam);

        businessProcessTask.click();
        executedTask.click();
        submitButtonTask.click();
        sleep(2000);
        Assertions.assertEquals(taskStatusCheck.getText(), taskStatusCheckDoneParam);

        businessProcessTask.click();
        approvedTask.click();
        submitButtonTask.click();
        sleep(2000);
        Assertions.assertEquals(taskStatusCheck.getText(), taskStatusCheckFinishedParam);

        doneTask.click();
        sleep(2000);
        Assertions.assertEquals(taskStatusCheck2.getText(), taskStatusCheckFinished2Param);

    }
}
