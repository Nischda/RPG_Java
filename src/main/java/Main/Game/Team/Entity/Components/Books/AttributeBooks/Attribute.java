package Main.Game.Team.Entity.Components.Books.AttributeBooks;


public abstract class Attribute { //Could combine stats and make constructor have get string to return name

    public abstract int get();
    public abstract String getString();
    public abstract void addMod( double value);
    public abstract void add( int value);
    public abstract void addEquipment(int value);
    public abstract void resetEquipment();
    public abstract String toString();

}
