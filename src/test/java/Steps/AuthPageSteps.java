package Steps;

import elements.AuthPageElements;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class AuthPageSteps extends AuthPageElements {
    public static void loginFunc(String loginInputParam, String passwordInputParam) {
        loginInput.setValue(loginInputParam);
        passwordInput.setValue(passwordInputParam);

        Assertions.assertEquals(loginInput.getValue(), loginInputParam);
        Assertions.assertEquals(passwordInput.getValue(), passwordInputParam);

        loginButton.shouldBe(visible, Duration.ofSeconds(3)).click();
    }
}
