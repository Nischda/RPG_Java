package Main.Game.Entity.Entities.Book.Books.Spells;


import Main.Game.Entity.Entities.Book.Books.Ability;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.Scanner;

public class Spark extends Ability {

    private Scanner in = new Scanner(System.in);

    @Override
    public void use(Entity actor, int damage, ArrayList<Entity> targets) {
        System.out.println("Choose your target (up to " + targets.size() + ")");
        Entity target = targets.get(Integer.parseInt(in.nextLine()));
        target.receiveSpellDamage(damage, actor.name());
    }
    @Override
    public void aiUse(Entity actor, int damage, ArrayList<Entity> targets) {
        Entity target = targets.get(0); //ToDo sort targets by Hp missing
        System.out.println(actor.getName() + " uses " + this.toString() + " on " + target.getName() + ".");
        target.receiveSpellDamage(damage, actor.name());
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
