package StepDefinition;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import steps.authPageSteps;
import steps.mainPageSteps;
import steps.singleTaskPageSteps;
import steps.tasksPageSteps;
import Hooks.webHooks;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
public class StepDefinitions extends webHooks {
    @Дано("Начальная страница")
            public void chromeTest() {
        open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();
    }
    @Когда("Пользователь вводит логин {string}, пароль {string} и нажимает Войти")
    public static void loginFunc(String loginInputParam, String passwordInputParam){
        authPageSteps.loginFunc(loginInputParam, passwordInputParam);
    }
    @Когда("Пользователь жмет кнопку Проекты и выбирает из списка Тест. Открывается проект")
    public static void goToRequiredProject() {
        mainPageSteps.goToRequiredProject();

    }
    @И("На странице указано количество задач")
    public static void showAmountOfCompletedTasks() {
        tasksPageSteps.showAmountOfCompletedTasks();
    }
    @Тогда("Клик по поиску, ввести текст {string}, выбрать первый результат поиска")
    public static void search(String searchInputParam) {
        tasksPageSteps.search(searchInputParam);
    }
@Когда("Откроется страница единичного задания, будут выведены Статус задания и Версия задания")
    public static void taskCheck() {
        singleTaskPageSteps.taskCheck();
    }
    @Дано("Пользователь создает задание, заполняя в нем поля: Тип задачи {string} Тема {string} Исправить в версиях {string} Приоритет {string} Метки {string} Описание {string} Окружение {string} Затронуты версии Исполнитель")
    public static void createTask(String issueTypeParam,
                                  String issueValueParam,
                                  String versionFieldParam,
                                  String priorityFieldParam,
                                  String labelSelectTestParam,
                                  String descriptionAreaParam,
                                  String testEnvironmentAreaParam) {
        singleTaskPageSteps.createTask(issueTypeParam,
                                       issueValueParam,
                                       versionFieldParam,
                                       priorityFieldParam,
                                       labelSelectTestParam,
                                       descriptionAreaParam,
                                       testEnvironmentAreaParam);
    }
}
