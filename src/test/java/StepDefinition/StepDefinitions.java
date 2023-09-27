package StepDefinition;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import steps.authPageSteps;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static elements.authPageElements.loginInput;

public class StepDefinitions {
    @Дано("Начальная страница")
            public void chromeTest() {
        open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();
    }
    @Когда("Ввод в поле логин {string}, пароль {string}, клик по кнопке ВОЙТИ")
    public static void loginFunc(String loginInputParam, String passwordInputParam){
        authPageSteps.loginFunc(loginInputParam, passwordInputParam);
    }
    @Тогда("Перейти в список")
    public static void goToRequiredProject() {
        listOfCurrentProjects.click();
        requiredProject.click();
        Assertions.assertTrue((!loginInput.exists()));
    }
    public static void taskCheck() {
        System.out.println("Статус текущей задачи:" + status.getText());
        System.out.println("Версия текущей задачи:" + version.getText());
    }
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
    public static void createTask(String issueTypeParam,
                                  String issueValueParam,
                                  String versionFieldParam,
                                  String priorityFieldParam,
                                  String labelSelectTestParam,
                                  String descriptionAreaParam,
                                  String testEnvironmentAreaParam) {
        create.click();
        if (!issueType2.getValue().equals(issueTypeParam)) {
            issueType.click();
            sleep(1000);
            issueTypeBug.click();
        }
        issueValue.setValue(issueValueParam);
        descriptionArea.sendKeys(descriptionAreaParam);
        versionField.click();
        if (!priorityFieldMedium.getValue().equals(priorityFieldParam)) {
            priorityField.click();
            priorityFieldMedium.click();
        }
        labelSelect.sendKeys(labelSelectTestParam);
        labelSelect.sendKeys(Keys.RETURN);
        testEnvironmentArea.sendKeys(testEnvironmentAreaParam);
        usedVersions.click();
        chooseExecutor.click();

        taskTest(issueTypeParam,
                issueValueParam,
                versionFieldParam,
                priorityFieldParam,
                labelSelectTestParam,
                descriptionAreaParam,
                testEnvironmentAreaParam);

        createTaskSubmit.click();
        tasksPage.click();
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
        sleep(1000);
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
