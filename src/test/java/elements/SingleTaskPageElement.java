package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SingleTaskPageElement extends PageElementsParams {
    public static SelenideElement status = $x("//span [@id='status-val']//span");
    public static SelenideElement version = $x("//span[@class='shorten']//a");
    public static SelenideElement create = $x("//li[@id='create-menu']//a[@id='create_link']");
    public static SelenideElement issueType = $x("//input[@id='issuetype-field']");
    public static SelenideElement issueType2 = $x("//input[@id='issuetype-field']");
    public static SelenideElement issueTypeBug = $x("//div[@class='aui-list-scroll']//li[contains(@id,'ошибка')]");
    public static SelenideElement issueValue = $x("//input[@id='summary']");
    public static SelenideElement descriptionArea = $x("//textarea[@id='description']");
    public static SelenideElement versionField = $x("//select[@id='fixVersions']//option[contains(text(),'Version 2.0')]");
    public static SelenideElement priorityField = $x("//input[@id='priority-field']");
    public static SelenideElement priorityFieldMedium = $x("//input[@id='priority-field']");
    public static SelenideElement labelSelect = $x("//textarea[@id='labels-textarea']");
    public static SelenideElement labelSelectTest = $x("//div[@class='representation']//span//span");
    public static SelenideElement testEnvironmentArea = $x("//textarea[@id='environment']");
    public static SelenideElement usedVersions = $x("(//label[contains(text(),'Затронуты версии')])[3]//ancestor::div[@class='field-group aui-field-versionspicker select-list-renderer']//select//option[contains(text(),'Version 2.0')]");
    public static SelenideElement chooseExecutor = $x("//button[@id='assign-to-me-trigger']");
    public static SelenideElement createTaskSubmit = $x("//input[@id='create-issue-submit']");
    public static SelenideElement tasksPage = $x("(//a[@class='aui-nav-item '])[5]");
}
