package Main.Game.Utility;


import java.util.HashMap;

public class Library {

    private static HashMap<String, String> helpMap = new HashMap<>();


    public static void printHelp(String string) {
        helpMap.put("test", "test worked");
        if(helpMap.containsKey(string)) {
            System.out.println(helpMap.get(string));
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }
        else {
            System.out.println("No information listet for :" + string + ".");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }
    }

    public static void put(String name, String info) {
        helpMap.put(name, info);
    }
}


