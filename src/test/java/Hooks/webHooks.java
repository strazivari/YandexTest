package Hooks;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static elements.authPageElements.loginInput;

import elements.param;
import io.cucumber.junit.Cucumber;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;

import java.time.Duration;


@RunWith(Cucumber.class)
public class webHooks extends param {
    public void chromeTest() {
        open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();
    }
}

