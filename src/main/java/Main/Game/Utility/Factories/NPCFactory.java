package Main.Game.Utility.Factories;


import Main.Game.Team.Entity.Entity;
import Main.Game.Team.Team;
import Main.Game.Utility.FileHandler.TxtReader;

import java.io.File;

public final class NPCFactory {

    public static Team createNPCs(File file, int npcCount, int traitCount) {

            Team npcList = new Team("EnemyTeam");
            for(int i = 0; i < npcCount; i++) {
                Entity npc = TxtReader.generateNPC(file, traitCount);
                npcList.add(npc);
            }
            return npcList;
        }
}