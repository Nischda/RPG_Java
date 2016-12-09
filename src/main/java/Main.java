import ProfessionLists.Professions.Duelist;
import RaceLists.Races.Dwarf;
import TraitLists.Traits.*;

public class Main {

    public static void loop() {
        Game.loop();
    }

    public static void main(String[] args) {
        new Duelist().addToList();
        new Dwarf().addToList();
        new Cursed().addToList();
        Game.loop();

    }
}
