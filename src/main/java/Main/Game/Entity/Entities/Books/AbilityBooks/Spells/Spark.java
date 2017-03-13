package Main.Game.Entity.Entities.Books.AbilityBooks.Spells;


import Main.Game.Entity.Entities.Books.AbilityBooks.Ability;
import Main.Game.Entity.Entities.Entities;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Spark extends Ability {

    private Scanner in = new Scanner(System.in);

    @Override
    public ArrayList<HashMap<Entity, Integer>> use(Entity actor, int damage, Entities targets) {
        System.out.println("Choose your target (up to " + targets.size() + ")");
        Entity target = targets.get(Integer.parseInt(in.nextLine())-1);
        return new ArrayList<>(Arrays.asList(target.receivePhysicalDamage(damage, actor.getName())));
    }
    @Override
    public void aiUse(Entity actor, int damage, Entities targets) {
        Entity target = targets.get(0); //ToDo sort targets by Hp missing
        System.out.println(actor.getName() + " uses " + this.toString() + " on " + target.getName() + ".");
        target.receiveSpellDamage(damage, actor.getName());
    }

    @Override
    public boolean fulfillRequirement() {
        return true; //add conditions
    }
    @Override
    public String toString() {
        return "spark";
    }
}
