package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static api.PotatoApi.*;
import static api.RickMortyApi.*;


public class ApiJsonTest {
    @Before
    public static void allureSubThreadParallel(){
        String listenerName = "AllureSelenide";
        if (!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    (new AllureSelenide().screenshots(true).savePageSource(false)));

    }
    @Test
    public void rickMortyTest() {
        rickMorty("2");
        gettingLastEpisode();
        gettingCharLastEpisode();
        gettingCharInfoLastEpisode();
        locCheck(charLoc, lastCharLocation);
        speciesCheck(charSpecies, lastCharSpecies);
    }

    @Test
    public void jsonTest() throws IOException {
        getJSONFromFile();
        nameCheck();
        jobCheck();
        idCheck();
        createdAtCheck();
    }
}
