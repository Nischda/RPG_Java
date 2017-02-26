package Main.Game.Entity.Entities.Item;

public interface Equipable {
    public boolean isEquipableOn(String slot);
    public int getDamage();
    public int getSpeed();
    public int getPrice();
    public int getWeight();
}

