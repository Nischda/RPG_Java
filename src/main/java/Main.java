import Professions.*;
import Races.*;

public class Main {

    public static void loop() {
        Game.loop();
    }

    public static void main(String[] args) {
        new Duelist();

        new Dwarf();
        Game.loop();

    }
}
