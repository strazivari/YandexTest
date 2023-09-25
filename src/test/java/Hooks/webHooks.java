package Hooks;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
public class webHooks {
    public void chromeTest() {
        open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();
    }
}
