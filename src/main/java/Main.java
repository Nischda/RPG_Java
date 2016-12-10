import Entities.ProfessionLists.Professions.Duelist;
import Entities.RaceLists.Races.*;
import Entities.TraitLists.Traits.*;

public class Main {

    public static void loop() {
        Game.loop();
    }

    public static void main(String[] args) {
        new Duelist().addToList();

        new Dwarf().addToList();
        new Elf().addToList();
        new Ent().addToList();
        new Necrotic().addToList();


        new Cursed().addToList();
        Game.loop();

    }
}
