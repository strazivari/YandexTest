package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPageElements {
    public static SelenideElement requiredProject = $x("//a[contains(text(),'Test (TEST)')]");
    public static SelenideElement listOfCurrentProjects = $x("//a[@id='browse_link']");
}
