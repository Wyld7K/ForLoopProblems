import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

public class Utility {
    private static Scanner s = new Scanner(System.in);

    // ======TERMINAL METHODS======

    public static void sleepThread(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000);

        } catch (Exception e) {
            System.out.print(
                    e.toString().replaceAll("\\[", "").replaceAll("]", ""));
        }
    }

    public static boolean YayOrNay() {
        System.out.println("Play Again? (Y/N)");
        String answer = "";
        do {
            answer = s.nextLine().substring(0).toUpperCase();
        } while (!(answer.equals("Y") || answer.equals("N")));
        if (answer.equals("Y"))
            return true;
        return false;
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // <<<<PRINTDOTSLEEP METHODS>>>>>

    /**
     * 
     * @param finalPrintMessage The last thing printed after dots
     *
     */
    public static void printSleepDotsMessage(String finalPrintMessage, String calcMessage) {
        System.out.print(calcMessage);
        sleepThread(1);
        System.out.print(".");
        sleepThread(1);
        System.out.print(".");
        sleepThread(1);
        System.out.println(".");
        sleepThread(1);
        System.out.println(finalPrintMessage);
    }

    public static void printSleepDotsMessage(String finalPrintMessage, String calcMessage, int sleepTime) {
        System.out.print(calcMessage);
        sleepThread(sleepTime);
        System.out.print(".");
        sleepThread(sleepTime);
        System.out.print(".");
        sleepThread(sleepTime);
        System.out.println(".");
        sleepThread(sleepTime);
        System.out.println(finalPrintMessage);
    }

    public static void printSleepDotsMessage(String startingMessage, String calcMessage, String finalMessage,
            int sleepTime) {
        System.out.print("Your answer is");
        sleepThread(sleepTime);
        System.out.print(".");
        sleepThread(sleepTime);
        System.out.print(".");
        sleepThread(sleepTime);
        System.out.println(".");
        sleepThread(sleepTime);
        System.out.println(finalMessage);
    }

    // ======ARRAY METHODS======

    // <<<<swapElementsInArr METHODS>>>>>
    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // ======STRING METHODS======
    public static int numVowels(String word) {
        int count = 0;
        List<Character> vowels = new ArrayList<Character>(Arrays.asList(new Character[] { 'A', 'E', 'I', 'O', 'U' }));

        for (int i = 0; i < word.length(); i++) {
            if (vowels.contains(word.toUpperCase().charAt(i))) {
                count++;
            }

        }
        return count;

    }

    public static String reverseIt(String word) {
        String tempWord = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            tempWord += word.charAt(i);
        }
        return tempWord;
    }

    public String sortAlphebetical(String text) {

        text = text.toLowerCase();
        char[] letters = text.toCharArray();
        String finalWord = "";

        // Selection Sort Algorithm
        for (int i = letters.length - 1; i > 0; i--) {

            int largest = 0;
            for (int j = 1; j <= i; j++) {
                if (((int) letters[j]) > ((int) letters[largest]))
                    largest = j;
            }
            Utility.swap(letters, largest, i);

        }
        for (char letter : letters) {
            finalWord += letter;
        }
        System.out.println("THE FINAL WORD: " + finalWord);
        return finalWord;

    }

}