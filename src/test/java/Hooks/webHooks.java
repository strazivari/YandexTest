package Hooks;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import elements.param;
public class webHooks extends param {
    public void chromeTest() {
        open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();
    }
}
