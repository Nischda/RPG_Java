package Main.Game.Entity.Entities.Item;

import Main.Game.Entity.Entities.Entities;
import Main.Game.Entity.Entity;

public interface Equipable {

    public void equip(Entity entity);

    public int getDamage();
    public int getStamina();
    public int getCharisma();
    public int getEffectChance();
    public int getSpellDamage();
    public int getHpReg();
    public int getMpReg();
    public int getArmor();
    public int getResistance();
    public int getMaxHp();
    public int getMaxMp();

    public int getSpeed();
    public int getPrice();
    public int getWeight();
    public String getSlot();
}