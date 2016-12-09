package TraitLists;

public abstract class Trait {
    private Trait[] traits;

    public  boolean exists(String otherName) {
        for(Trait traitName : traits){
            if(traitName.toString().equals(otherName)) {
                return true;
            }
        }
        return false;
    }

    public Trait getTrait(String otherName) {
        for(Trait trait : traits){
            if(trait.toString().equals(otherName)) {
                System.out.println("trait: " + trait); //NullPointerException
                return trait;
            }
        }
        return null;
    }

    public void activateTrait() {
    }
    public abstract  String toString();

    public String toS() {
        return traits.toString();
    }
}
