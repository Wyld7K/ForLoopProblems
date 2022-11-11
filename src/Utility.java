import java.util.Scanner;

import javax.swing.*;

public class Utility {

    public static JButton getElementsJButton(JButton[] arr) {
        for (JButton JButton : arr) {

            return JButton;
        }
        return new JButton();

    }

    public static char getElementsString(String string) {
        for (char letter : string.toCharArray()) {

            return letter;
        }
        return '\u0000';

    }

    public static void sleepThread(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static boolean YayOrNay() {
        Scanner s = new Scanner(System.in);
        System.out.println("Play Again? (Y/N)");
        String answer = "";
        while (!answer.equals("Y") || answer.equals("N"))
            answer = s.nextLine().substring(0).toUpperCase();
        if (answer.equals("Y"))
            return true;
        return false;
    }
}