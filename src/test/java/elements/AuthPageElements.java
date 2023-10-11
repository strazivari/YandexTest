package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPageElements {
    public static SelenideElement loginInput = $x("//input[@id='login-form-username']");
    public static SelenideElement passwordInput = $x("//input[@id='login-form-password']");
    public static SelenideElement loginButton = $x("//input[@value='Войти' or @value='Вход']");
}
