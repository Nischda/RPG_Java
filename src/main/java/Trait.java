
public enum Trait {
    ENTHUSIASTIC, ENERGETIC, CURSED, FORGOTTEN;

    public static boolean exists(String otherName) {
        for(Trait traitName : Trait.values()){
            if(traitName.toString().equals(otherName)) {
                return true;
            }
        }
        return false;
    }

    public static Trait getTrait(String otherName) {
        for(Trait trait : Trait.values()){
            if(trait.toString().equals(otherName)) {
                System.out.println("trait: " + trait); //NullPointerException
                return trait;
            }
        }
        return null;
    }

    public static void activateTrait(Trait trait) {
        switch (trait) {
            case ENTHUSIASTIC:
                System.out.println("Mondays are bad.");
                break;

            case ENERGETIC:
                System.out.println("Fridays are better.");
                break;

            case CURSED:
                System.out.println("Weekends are best.");
                break;

            case FORGOTTEN:
                System.out.println("Weekends are best.");
                break;

            default:
        }
    }

    public static String toS() {
        return "ENTHUSIASTIC, ENERGETIC, CURSED, FORGOTTEN;";
    }
}
