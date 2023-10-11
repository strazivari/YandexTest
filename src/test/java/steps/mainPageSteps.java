package steps;

import elements.mainPageElements;
import org.junit.jupiter.api.Assertions;

import static elements.authPageElements.loginInput;

public class mainPageSteps extends mainPageElements {
    public static void goToRequiredProject() {
        listOfCurrentProjects.click();
        requiredProject.click();
        Assertions.assertTrue((!loginInput.exists()));
    }

}
