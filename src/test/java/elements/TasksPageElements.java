package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TasksPageElements extends PageElementsParams {
    public static SelenideElement tasksPage = $x("(//a[@class='aui-nav-item '])[5]");
    public static SelenideElement completedTasks = $x("//div[@class='showing']");
    public static SelenideElement searchInput = $x("//input[@id='quickSearchInput']");
    public static SelenideElement firstSearchResult = $x("//li[@class='quick-search-result-item' and @original-title='TestSelenium'][1]");
    public static SelenideElement searchFilter = $x("//button[@id='subnav-trigger']");
    public static SelenideElement searchFilterTest = $x("//span[@class='subnavigator-title']");
    public static SelenideElement searchSortTest = $x("//a[@class='order-options aui-button aui-style-default jira-aui-dropdown2-trigger']//span");
    public static SelenideElement taskStatusCheck = $x("//span[@id='status-val']");
    public static SelenideElement taskStatusCheck2 = $x("//li[@class='item item-right']//div[@class='wrap']//strong[@title='Решение']//following-sibling::span[contains(text(),' ')]");
    public static SelenideElement myOpenedTasks = $x("//div[@id='subnav-opts']//div[@class='aui-dropdown2-section']//li//a[contains(text(),'Мои открытые задачи')]");
    public static SelenideElement filterActivation = $x("//div[@class='order-by-fields']");
    public static SelenideElement filterByDate = $x("//div[@class='aui-list']//label[contains(@title,'Cоздано')]");
    public static SelenideElement lastTask = $x("(//div[@class='list-panel']//li)[1]");
    public static SelenideElement inProgressTask = $x("//div[@class='command-bar']//span[contains(text(),'В работе')]");
    public static SelenideElement businessProcessTask = $x("//div[@class='command-bar']//span[contains(text(),'Бизнес-процесс')]");
    public static SelenideElement executedTask = $x("//div[@class='command-bar']//span[contains(text(),'Исполнено')]");
    public static SelenideElement submitButtonTask = $x("//input[@id='issue-workflow-transition-submit']");
    public static SelenideElement reopenedTask = $x("//div[@class='command-bar']//span[contains(text(),'Переоткрыт')]");
    public static SelenideElement inWorkTask = $x("//div[@class='command-bar']//span[contains(text(),'Взят в работу')]");
    public static SelenideElement approvedTask = $x("//div[@class='command-bar']//span[contains(text(),'Подтверждено')]");
    public static SelenideElement doneTask = $x("//div[@class='command-bar']//span[contains(text(),'Выполнено')]");

}
