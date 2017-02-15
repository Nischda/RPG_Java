package Entities.RaceLists.Races;


import Entities.Entity;
import Entities.Player;
import Entities.RaceLists.Race;

public class Elf extends Race{

    private String description = "An Elf";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Entity entity) {
        entity.setBaseAttributes(14,10,8,5,11,12,10);
    }

    @Override
    public String toString() {
        return "ELF";
    }

}
