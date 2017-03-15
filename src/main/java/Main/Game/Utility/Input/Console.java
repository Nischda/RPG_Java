package Main.Game.Utility.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public  class Console {


    public static String getStringInput() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        try {
            input = in.readLine().toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static Integer getIntegerInput() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int input = -1;

        try {
            input = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
