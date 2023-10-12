package Hooks;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.logevents.SelenideLogger;
import elements.PageElementsParams;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Дано;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;

public class WebHooks extends PageElementsParams {
    @Before
    @Step("Открываем начальную страницу")
    @Дано("Начальная страница")
    public void chromeTest() {
        open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();
    }
    
    @Before
    public static void allureSubThreadParallel() {
        String listenerName = "AllureSelenide";
        if(!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    (new AllureSelenide().screenshots(true).savePageSource(false)));
    }
}

