import Professions.*;
import Races.*;
import TraitLists.Traits.*;

public class Main {

    public static void loop() {
        Game.loop();
    }

    public static void main(String[] args) {
        new Duelist();
        new Dwarf();
        new Cursed();
        Game.loop();

    }
}
