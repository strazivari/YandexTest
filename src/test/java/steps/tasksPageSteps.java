package steps;

import elements.tasksPageElements;
import org.junit.jupiter.api.Assertions;
import static com.codeborne.selenide.Selenide.sleep;

public class tasksPageSteps extends tasksPageElements {
    public static void showAmountOfCompletedTasks() {
        tasksPage.click();
        String text = completedTasks.getText();
        String[] words = text.split(" ");
        System.out.println("Количество задач в проекте:" + words[2]);

    }

    public static void search() {
        searchInput.setValue("TestSelenium");
        firstSearchResult.click();
    }

    public static void completeTask() {
        searchFilter.click();
        myOpenedTasks.click();
        Assertions.assertEquals(searchFilterTest.getText(), "Мои открытые задачи");

        filterActivation.click();
        filterByDate.click();
        sleep(1000);
        Assertions.assertEquals(searchSortTest.getText(), "Сортировать по Cоздано");

        lastTask.click();

        inProgressTask.click();
        sleep(1000);
        Assertions.assertEquals(taskStatusCheck.getText(), "В РАБОТЕ");

        businessProcessTask.click();
        executedTask.click();
        submitButtonTask.click();
        sleep(1000);
        Assertions.assertEquals(taskStatusCheck.getText(), "РЕШЕННЫЕ");

        businessProcessTask.click();
        reopenedTask.click();
        submitButtonTask.click();
        sleep(1000);
        Assertions.assertEquals(taskStatusCheck.getText(), "ПЕРЕОТКРЫТ");

        businessProcessTask.click();
        inWorkTask.click();
        sleep(1000);
        Assertions.assertEquals(taskStatusCheck.getText(), "В РАБОТЕ");

        businessProcessTask.click();
        executedTask.click();
        submitButtonTask.click();
        sleep(1000);
        Assertions.assertEquals(taskStatusCheck.getText(), "РЕШЕННЫЕ");

        businessProcessTask.click();
        approvedTask.click();
        submitButtonTask.click();
        sleep(1000);
        Assertions.assertEquals(taskStatusCheck.getText(), "ГОТОВО");

        doneTask.click();
        sleep(1000);
        Assertions.assertEquals(taskStatusCheck2.getText(), "Готово");

    }
}
