import iFellow.ClockDegreeCalc;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;

public class RunTest {

//    @Nested
//    class openTest {
//        @Test
//        public void main(String[] args) {
//            open("https://demoqa.com/automation-practice-form");
//            $("#firstName").setValue("Vladislav");
//        }
//    }
    
    @Test
    @DisplayName("24 hours format test")
    public void degree1Test(){
        double degree = ClockDegreeCalc.cornDegree(22,30);
        double a = 135.0;
        Assertions.assertEquals(a, degree);
    }
    @Test
    @DisplayName("12 hours format test")
    public void degree2Test(){
        double degree = ClockDegreeCalc.cornDegree(11,30);
        double a = 165.0;
        Assertions.assertEquals(a, degree);
    }
    @Test
    @DisplayName("Wrong hours format test")
    public void degree3Test(){
        double degree = ClockDegreeCalc.cornDegree(123,1233);
        double a = 161.5;
        if (degree == 0) {
            System.out.println ("ERROR");
        }
        else {
        Assertions.assertEquals(a, degree);
        }
    }
    @Test
    @DisplayName("'False' check")
    public void degree4Test(){
        double degree = ClockDegreeCalc.cornDegree(12,22);
        double a = 33123;
        Assertions.assertEquals(a, degree);
    }
    @BeforeAll
    public static void init(){
        System.out.println("ClockDegreeCalculator calculation check");
    }
    @AfterAll
    public static void cleanUp(){
        System.out.println("After All cleanUp() method called");
    }
}
