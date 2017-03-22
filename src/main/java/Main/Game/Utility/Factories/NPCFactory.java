package Main.Game.Utility.Factories;


import Main.Game.Team.Entity.Components.Books.PassiveBooks.TraitBook.Trait;
import Main.Game.Team.Entity.Components.Books.PassiveBooks.TraitBook.TraitBook;
import Main.Game.Team.Entity.Entity;
import Main.Game.Team.Team;
import Main.Game.Utility.FileHandler.TxtReader;

import java.io.File;

public final class NPCFactory {

    public static Team createNPCs(File file, int npcCount, int traitCount) {

            Team npcList = new Team("EnemyTeam");
            for(int i = 0; i < npcCount; i++) {
                Entity npc = TxtReader.generateNPC(file, chooseTraits(traitCount));
                npcList.add(npc);
            }
            return npcList;
        }

    public static TraitBook chooseTraits(int traitCount) {
        TraitBook traitBook = new TraitBook();
        for(int i = 0; i <traitCount; i++) {
            Trait trait = chooseTrait();
            traitBook.add(trait);
        }
        return traitBook;
    }

    public static Trait chooseTrait() {
        Trait trait = Trait.getTrait("cursed");
        return trait;
    }

}