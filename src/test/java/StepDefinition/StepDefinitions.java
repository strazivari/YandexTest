package StepDefinition;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import steps.AuthPageSteps;
import steps.MainPageSteps;
import steps.SingleTaskPageSteps;
import steps.TasksPageSteps;
import Hooks.WebHooks;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class StepDefinitions {


    @Step("Форма ввода логина, пароля")
    @Когда("Пользователь вводит логин {string}, пароль {string} и нажимает Войти")
    public static void loginFunc(String loginInputParam, String passwordInputParam) {
        AuthPageSteps.loginFunc(loginInputParam, passwordInputParam);
    }

    @Step("Открытие списка тестов, выбор конкретного теста")
    @Когда("Пользователь жмет кнопку Проекты и выбирает из списка Тест. Открывается проект")
    public static void goToRequiredProject() {
        MainPageSteps.goToRequiredProject();

    }

    @Step("Отображение количества задач в проекте")
    @И("На странице указано количество задач")
    public static void showAmountOfCompletedTasks() {

        TasksPageSteps.showAmountOfCompletedTasks();
    }

    @Step("Поиск, переход в тест TestSelenium")
    @Тогда("Клик по поиску, ввести текст {string}, выбрать первый результат поиска")
    public static void search(String searchInputParam) {

        TasksPageSteps.search(searchInputParam);
    }

    @Step("Проверка статуса и версии задания")
    @Когда("Откроется страница единичного задания, будут выведены Статус задания {string} и Версия задания {string}")
    public static void taskCheck(String taskStatusCheckInWorkParam, String versionFieldParam) {
        SingleTaskPageSteps.taskCheck(taskStatusCheckInWorkParam, versionFieldParam);
    }

    @Step("Заполнение при созданнии задания")
    @Дано("Пользователь создает задание, заполняя в нем поля: " +
            "Тип задачи {string} " +
            "Тема {string} " +
            "Исправить в версиях {string} " +
            "Приоритет {string} " +
            "Метки {string} " +
            "Описание {string} " +
            "Окружение {string} " +
            "Затронуты версии Исполнитель")
    public static void createTask(String issueTypeParam,
                                  String issueValueParam,
                                  String versionFieldParam,
                                  String priorityFieldParam,
                                  String labelSelectTestParam,
                                  String descriptionAreaParam,
                                  String testEnvironmentAreaParam) {
        SingleTaskPageSteps.createTask(issueTypeParam,
                issueValueParam,
                versionFieldParam,
                priorityFieldParam,
                labelSelectTestParam,
                descriptionAreaParam,
                testEnvironmentAreaParam);
    }

    @Step("Изменение статуса задания")
    @Тогда("Выполняются проверки работоспособности статуса задачи " +
            "Сортировка {string} " +
            "Фильтрация {string} " +
            "статусЗадачиИзмененНа {string} " +
            "статусЗадачиИзмененНа {string} " +
            "статусЗадачиИзмененНа {string} " +
            "статусЗадачиИзмененНа {string} " +
            "статусЗадачиИзмененНа {string}")
    public void completeTask(String searchSortTestParam,
                             String searchFilterTestParam,
                             String taskStatusCheckDoneParam,
                             String taskStatusCheckInWorkParam,
                             String taskStatusCheckReopenParam,
                             String taskStatusCheckFinishedParam,
                             String taskStatusCheckFinished2Param) {
        TasksPageSteps.completeTask(searchSortTestParam,
                searchFilterTestParam,
                taskStatusCheckDoneParam,
                taskStatusCheckInWorkParam,
                taskStatusCheckReopenParam,
                taskStatusCheckFinishedParam,
                taskStatusCheckFinished2Param);
    }
}
