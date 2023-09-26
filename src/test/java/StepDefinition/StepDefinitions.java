package StepDefinition;

import io.cucumber.java.ru.Дано;

public class StepDefinitions {
    @Дано ("Сумма")
        public void sumFunction() {
        int a = 5;
        int b = 4;
        int sum = a + b;
        System.out.println(sum);
    }
}
