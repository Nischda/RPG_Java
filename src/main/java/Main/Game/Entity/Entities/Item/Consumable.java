package Main.Game.Entity.Entities.Item;


import Main.Game.Entity.Entity;

public interface Consumable {
    public void use(Entity entity);
    public void effect();
}
