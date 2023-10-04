import org.junit.jupiter.api.Test;

import static api.apiSteps.*;

public class test {
    @Test public void SomeTest(){
        gettingCharLoc("2");
        gettingLastEpisode();
        gettingCharLastEpisode();
        gettingCharInfoLastEpisode();
        locCheck();
        speciesCheck();
    }
}
