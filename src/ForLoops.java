import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Write a description of class ForLoops here.
 *
 * @author Hudson Wesel
 * @version 1.0.0
 */
public class ForLoops {
    // NOTE:
    // 1. You can use a Scanner or JOptionPanes
    // 2. if using a Scanner user, easiest to use nextLine() and then convert ,
    // if neccessary

    Scanner s;

    // constructor:
    public ForLoops(Scanner sc) {
        s = sc; // save Scanner sent from runner so it can be used in this class

    }

    ///////////////////////////////////////
    /*
     * all the methods
     */

    /*
     * Write code that will get a String from the user, counts the number of vowels
     * in the text, and displays that number. Make sure you count vowels that are
     * uppercase or lowercase
     * 
     * Extension idea (simple): separately report the total of uppercase and of
     * lowercase of each vowel
     * Extension idea (medium): use some rule to count y as a vowel when you're sure
     * it's a vowel (okay if you don't catch all y's that are vowels)
     */
    public void countVowels() {
        int count = 0;
        List<Character> vowels = new ArrayList<Character>(Arrays.asList(new Character[] { 'A', 'E', 'I', 'O', 'U' }));

        String word = s.nextLine();
        for (int i = 0; i < word.length(); i++) {
            if (vowels.contains(Character.toString(word.toUpperCase().charAt(i)))) {
                count++;
            }

        }

    }

    public void reverseIt() {
        System.out.println("NO CODE YET!");
    }

    public void encrypt() {
        System.out.println("Give me text to encrypt");
        String text = s.nextLine();
        for (int i = 0; i < text.length(); i++) {
            text = text.substring(0, i) + text.charAt(i + 1) + text.charAt(i)
                    + text.substring(i + 1, text.length() - 1);
        }
        System.out.println(text);
    }

    public void showBoard() {
        String[][] board = new String[10][10];

        // Every even row
        // Every odd col
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (row % 2 == 0 && col % 2 != 0)
                    board[row][col] = "X";

                else
                    board[row][col] = "O";
            }
            for (String s : board[row]) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }

    public void showPrimes() {
        System.out.println("NO CODE YET!");
    }

    public void guessingGame() {
        int money = 1000;
        int randomStart = ((int) (Math.random() * 1000) + 1);
        int randomEnd = 0;
        int chosenNum = 0;
        int betAmount;
        int numGuesses = 0;

        boolean isPlaying = true;
        while (isPlaying) {
            while (randomStart > randomEnd)
                randomEnd = (int) ((Math.random() * 1000) + 1);
            System.out.println("RANDOM END" + randomEnd);

            // Select num
            while (randomStart > chosenNum && randomEnd > chosenNum)
                chosenNum = (int) (Math.random() * randomEnd);

            System.out.println("CHOSEN NUM" + chosenNum);

            System.out.println("Place your bet");
            betAmount = s.nextInt();

            System.out.println("BET AMOUNT");
            System.out.println("The range is from " + randomStart + " - " + randomEnd);

            System.out.println(chosenNum);
            System.out.println("Give me your guess");
            int guess = s.nextInt();

            while (guess != chosenNum) {

                if (numGuesses == 3) {
                    System.out.println("Here's a hint");
                    System.out.println("The number is greater than" + (randomStart + (randomEnd - chosenNum) / 2));
                }
                if (numGuesses == 6) {
                    System.out.println("Here's a hint");
                    System.out.println("The number is lower than" + (chosenNum + (randomEnd - chosenNum) / 2));
                }
                if (guess > chosenNum) {
                    System.out.println("Your guess is too high!");
                    numGuesses++;
                } else {
                    System.out.println("Your guess is too low!");
                    numGuesses++;
                }

                guess = s.nextInt();
            }
            money += betAmount;

            System.out.println("Remaining Money: $" + money);

            isPlaying = Utility.YayOrNay();

            Utility.sleepThread(2);

        }
    }

    public void yourOwn() {
        System.out.println("NO CODE YET!");
    }

    /**
     * THESE 3 ARE HONORS ONLY:
     */
    public void countConsonants() {
        System.out.println("NO CODE YET!");
    }

    public void showFancyBoard() {
        System.out.println("NO CODE YET!");
    }

    public void reverseByWord() {
        System.out.println("NO CODE YET!");
    }
}
