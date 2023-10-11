package steps;

import elements.SingleTaskPageElement;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.sleep;

public class SingleTaskPageSteps extends SingleTaskPageElement {
    public static void taskCheck(String taskStatusCheckInWorkParam, String versionFieldParam) {
        try {
            Assertions.assertEquals(taskStatusCheckInWorkParam, status.getText());
            Assertions.assertEquals(versionFieldParam ,version.getText());
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void taskTest(String issueTypeParam,
                                String issueValueParam,
                                String versionFieldParam,
                                String priorityFieldParam,
                                String labelSelectTestParam,
                                String descriptionAreaParam,
                                String testEnvironmentAreaParam) {
        Assertions.assertEquals(issueType.getValue(), issueTypeParam);
        Assertions.assertEquals(issueValue.getValue(), issueValueParam);
        Assertions.assertEquals(versionField.getText(), versionFieldParam);
        Assertions.assertEquals(priorityField.getValue(), priorityFieldParam);
        Assertions.assertEquals(labelSelectTest.getText(), labelSelectTestParam);
        Assertions.assertEquals(descriptionArea.getValue(), descriptionAreaParam);
        Assertions.assertEquals(testEnvironmentArea.getValue(), testEnvironmentAreaParam);
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
}
