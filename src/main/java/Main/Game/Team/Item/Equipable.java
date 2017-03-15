package Main.Game.Team.Item;

import Main.Game.Team.Entity.Entity;

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