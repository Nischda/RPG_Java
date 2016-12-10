package Entities.RaceLists.Races;


import Entities.Player;
import Entities.RaceLists.Race;

public class Necrotic extends Race{

    private String description = "A Necrotic";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Player player) {
        player.setBaseStrength(2);
        player.setBaseEndurance(12);
        player.setBaseKnowledge(18);
        player.setBasePerception(4);
        player.setBaseMentality(16);
        player.setBaseHardening(7);
    }

    @Override
    public String toString() {
        return "NECROTIC";
    }

}
