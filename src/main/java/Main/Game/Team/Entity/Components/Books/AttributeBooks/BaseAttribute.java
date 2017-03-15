package Main.Game.Team.Entity.Components.Books.AttributeBooks;


public class BaseAttribute extends Attribute {

    private int multiplier;
    private String name;
    private int baseValue;
    private double mod = 1;
    private int value;
    private int equipmentValue;

    public BaseAttribute(int multiplier, String name, int value, Double mod) {
        this.multiplier = multiplier;
        this.name = name;
        this.baseValue = value;
        this.mod += mod;
        update();
    }

    @Override
    public int get() {
        return value;
    }
    @Override
    public String getString() {
        return Integer.toString(value);
    }

    @Override
    public void add( int value) {
        baseValue += value;
        update();
    }

    @Override
    public void addMod( double value) {
        mod += value;
        update();
    }

    @Override
    public void addEquipment(int value) {
        equipmentValue += value;
    }

    @Override
    public void resetEquipment() {
        equipmentValue = 0;
    }

    @Override
    public String toString() {
        return name;
    }

    private void update() {
        value = (int)(baseValue * mod) + equipmentValue;
    }
}
