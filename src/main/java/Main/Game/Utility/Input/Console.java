package Main.Game.Utility.Input;

import Main.Game.Utility.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class Console {

    private static String buffer;
    private static boolean gotBuffer;
    private static Pattern p = Pattern.compile("(-help)\\s(\\w*)");


    public static void input() {
        String input = readLine();
        Matcher m = p.matcher(input);
        if (m.find()) {
            Library.printHelp(m.group(2));
        } else {
            buffer = input;
            gotBuffer = true;
        }

    }

    public static boolean gotBuffer() {
        return gotBuffer;
    }

    public static String getBuffer() {
        gotBuffer = false;
        return buffer;
    }

    public static Integer intInput() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int input = -1;

        try {
            input = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static String toString(ArrayList<String> stringList) {
        String returnString = "";
        int index = 1;
        for (String string : stringList) {
            returnString += index + ". " + string + "\n";
            index++;
        }
        return returnString;
    }


    private static String readLine() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        try {
            input = in.readLine().toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static boolean isInteger(String s) {
        return s.matches("\\d*");
    }

}