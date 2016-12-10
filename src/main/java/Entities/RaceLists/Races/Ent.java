package Entities.RaceLists.Races;


import Entities.Player;
import Entities.RaceLists.Race;

public class Ent extends Race{

    private String description = "An Ent";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Player player) {
        player.setBaseStrength(17);
        player.setBaseEndurance(7);
        player.setBaseKnowledge(5);
        player.setBasePerception(2);
        player.setBaseMentality(3);
        player.setBaseHardening(18);
    }
    @Override
    public String toString() {
        return "ENT";
    }

}
