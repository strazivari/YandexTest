package steps;

import elements.singleTaskPageElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.sleep;

public class singleTaskPageSteps extends singleTaskPageElement {
    public static void taskCheck() {
        System.out.println("Статус текущей задачи:" + status.getText());
        System.out.println("Версия текущей задачи:" + version.getText());
    }
    public static void taskTest() {
        Assertions.assertEquals(issueType.getValue(), "Ошибка");
        Assertions.assertEquals(issueValue.getValue(), "TestSelenium");
        Assertions.assertEquals(versionField.getText(), "Version 2.0");
        Assertions.assertEquals(priorityField.getValue(), "Medium");
        Assertions.assertEquals(labelSelectTest.getText(), "bugBuzzers");
        Assertions.assertEquals(descriptionArea.getValue(), "Шаги:  1.Тест вызванных функций  2.Проверка результатов тестирования");
        Assertions.assertEquals(testEnvironmentArea.getValue(), "local machine");
    }
    public static void createTask() {
        create.click();
        if (!issueType2.getValue().equals("Ошибка")) {
            issueType.click();
            sleep(1000);
            issueTypeBug.click();
        }
        issueValue.setValue("TestSelenium");
        descriptionArea.sendKeys("Шаги:  1.Тест вызванных функций  2.Проверка результатов тестирования");
        versionField.click();
        if (!priorityFieldMedium.getValue().equals("Medium")) {
            priorityField.click();
            priorityFieldMedium.click();
        }
        labelSelect.sendKeys("bugBuzzers");
        labelSelect.sendKeys(Keys.RETURN);
        testEnvironmentArea.sendKeys("local machine");
        usedVersions.click();
        chooseExecutor.click();
        taskTest();
        createTaskSubmit.click();
        tasksPage.click();
    }
}
