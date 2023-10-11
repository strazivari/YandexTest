package steps;

import elements.MainPageElements;
import org.junit.jupiter.api.Assertions;

import static elements.AuthPageElements.loginInput;

public class MainPageSteps extends MainPageElements {
    public static void goToRequiredProject() {
        listOfCurrentProjects.click();
        requiredProject.click();
        Assertions.assertTrue((!loginInput.exists()));
    }

}
