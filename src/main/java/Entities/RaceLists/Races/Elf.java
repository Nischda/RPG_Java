package Entities.RaceLists.Races;


import Entities.Player;
import Entities.RaceLists.Race;

public class Elf extends Race{

    private String description = "An Elf";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Player player) {
        player.setBaseStrength(8);
        player.setBaseEndurance(17);
        player.setBaseKnowledge(12);
        player.setBasePerception(15);
        player.setBaseMentality(5);
        player.setBaseHardening(3);
    }

    @Override
    public String toString() {
        return "ELF";
    }

}
