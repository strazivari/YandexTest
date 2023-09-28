package steps;

import elements.authPageElements;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;

public class authPageSteps extends authPageElements{
    public static void loginFunc(String loginInputParam, String passwordInputParam){
        loginInput.setValue(loginInputParam);
        passwordInput.setValue(passwordInputParam);

        Assertions.assertEquals(loginInput.getValue(), loginInputParam);
        Assertions.assertEquals(passwordInput.getValue(), passwordInputParam);

        loginButton.shouldBe(visible, Duration.ofSeconds(3)).click();
    }
}
