import Entities.ProfessionLists.Professions.*;
import Entities.RaceLists.Races.*;
import Entities.TraitLists.Traits.*;

public class Main {


    public  static void main(String[] args) {
        new Duelist().addToList();
        new Bruiser().addToList();
        new Knight().addToList();
        new Kabbalist().addToList();
        new Trickster().addToList();


        new Dwarf().addToList();
        new Elf().addToList();
        new Ent().addToList();
        new Necrotic().addToList();

        new Cursed().addToList();
        new Game().loop();

    }
}
