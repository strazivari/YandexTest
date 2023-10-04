import org.junit.jupiter.api.Test;

import static api.RickMortyApi.*;

public class test {
    @Test
    public void SomeTest(){
        gettingCharLoc("2");
        gettingLastEpisode();
        gettingCharLastEpisode();
        gettingCharInfoLastEpisode();
        locCheck();
        speciesCheck();
    }
    @Test
    public void jsonTest() {

    }
}
