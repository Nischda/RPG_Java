package Entities.RaceLists.Races;


import Entities.Player;
import Entities.RaceLists.Race;

public class Dwarf extends Race {

    private String description = "A Dwarf";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Player player) {
        player.setBaseStrength(14);
        player.setBaseEndurance(10);
        player.setBaseKnowledge(8);
        player.setBasePerception(5);
        player.setBaseMentality(11);
        player.setBaseHardening(12);
    }

    @Override
    public String toString() {
        return "DWARF";
    }
}
