package Main.Game.Entity.Entities.Item;


import Main.Game.Entity.Entities.Entities;
import Main.Game.Entity.Entity;

public interface Consumable {
    public void use(Entities entities1, Entities entities2);
    public void effect();
}
