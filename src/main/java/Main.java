import Main.Game.Entity.Entities.RaceLists.Races.Dwarf;
import Main.Game.Entity.Entities.RaceLists.Races.Elf;
import Main.Game.Entity.Entities.RaceLists.Races.Ent;
import Main.Game.Entity.Entities.RaceLists.Races.Necrotic;
import Main.Game.Entity.Entities.TraitLists.Traits.Cursed;
import Main.Game.Entity.Entities.ProfessionLists.Professions.*;
import Main.Game.Game;

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
