package Tests;

import org.junit.jupiter.api.Test;
import java.io.IOException;

import static api.PotatoApi.*;
import static api.RickMortyApi.*;

public class test {
    @Test
    public void rickMortyTest(){
        rickMorty("2");
        gettingLastEpisode();
        gettingCharLastEpisode();
        gettingCharInfoLastEpisode();
        locCheck();
        speciesCheck();
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
