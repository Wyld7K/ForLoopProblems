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
        Utility.clearTerminal();

        int count = 0;
        List<Character> vowels = new ArrayList<Character>(Arrays.asList(new Character[] { 'A', 'E', 'I', 'O', 'U' }));

        System.out.println("Please Give Me A Word!");
        String word = s.nextLine();
        for (int i = 0; i < word.length(); i++) {
            if (vowels.contains((word.toUpperCase().charAt(i)))) {
                count++;
            }

        }
        Utility.printSleepDotsMessage("Number of Vowels: " + count, "Calculating");

    }

    public void reverseIt() {
        Utility.clearTerminal();

        System.out.println("Please give me a sentence or word and I will reverse it!");
        String word = s.nextLine();
        String tempWord = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            tempWord += word.charAt(i);
        }
        System.out.println(tempWord);

    }

    public void encrypt() {
        Utility.clearTerminal();

        System.out.println("Please give me a sentence or word and I will sort it alphebetical order!");
        Utility.sleepThread(1);

        String text = s.nextLine().toLowerCase();
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
        System.out.println(finalWord);

    }

    public void showBoard() {
        Utility.clearTerminal();

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
        System.out.println("Please give me a min value:");
        int min = s.nextInt();

        System.out.println("Please give me a max value:");
        int max = s.nextInt();

        for (int num = min; num <= max; num++) {
            boolean isPrime = true;

            if (num != 2) {
                if (num % 2 == 0)
                    continue;
                else {
                    long end = (long) (Math.sqrt(num) + 1);
                    for (long divisor = 3; divisor <= end; divisor += 2) {
                        if (num % divisor == 0) {
                            isPrime = false;
                            continue;
                        }

                    }
                    if (isPrime)
                        System.out.println("Prime Number: " + num);

                }
            }
        }
        System.out.println("Scroll up to see prime numbers");
        Utility.sleepThread(4);

    }

    public void guessingGame() {
        Utility.clearTerminal();

        int money = 1000;
        int randomStart = ((int) (Math.random() * 1000) + 1);
        int randomEnd = 0;
        int chosenNum = 0;
        int betAmount = 0;
        int numGuesses = 0;
        boolean isPlaying = true;

        while (isPlaying) {
            while (randomStart > randomEnd)
                randomEnd = (int) ((Math.random() * 1000) + 1);
            System.out.println("MAX VALUE: " + randomEnd);

            // Select num
            while (randomStart > chosenNum && randomEnd > chosenNum)
                chosenNum = (int) (Math.random() * randomEnd);

            System.out.println("CHOSEN NUM: " + chosenNum);

            do {
                System.out.println("Please Place Your Bet💸 ");
                betAmount = s.nextInt();
            } while (betAmount > money);

            System.out.println("The range is from " + randomStart + " - " + randomEnd);

            System.out.println("Please Give me your guess❔");
            int guess = s.nextInt();

            while (guess != chosenNum) {

                if (numGuesses == 3) {
                    System.out.println("Here's a hint");
                    Utility.sleepThread(1);
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
            System.out.println("That's Correct!");
            System.out.println("Remaining Money: $" + money);

            isPlaying = Utility.YayOrNay();

            Utility.clearTerminal();

        }
    }

    public void yourOwn() {
        System.out.println("NO CODE YET!");
    }

    /**
     * 
     * @return count of constonants
     */
    // I remember this from class
    public void countConsonants() {
        Utility.clearTerminal();

        System.out.println("Please give me a word!");
        String word = s.nextLine().toUpperCase();

        System.out.println("Number of Vowels!: " + Utility.numVowels(word));

        System.out.println("Number of Constanents!: " + (word.length() - Utility.numVowels(word)));

    }

    public void showFancyBoard() {
        Utility.clearTerminal();

        System.out.println("Please give me the dimensions of the board!");
        int dimensions = s.nextInt();
        String[][] board = new String[dimensions][dimensions];
        String firstChar, secondChar = "";

        // I used a doWhile b/c it doesn't get enough love X0X0 dowhile
        // jk lol it's just worse than while and for loops
        do {
            s.nextLine();
            System.out.println("Please type a single character on the keyboard");
            firstChar = s.nextLine();

            System.out.println("Please type ANOTHER😊 single character on the keyboard");
            secondChar = s.nextLine();

        } while (firstChar.length() > 1 || secondChar.length() > 1);

        // Every even row
        // Every odd col
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (col != 0 && row != 0 && dimensions % 2 != 0 && (col == 2 && row == 2)) {
                    board[row][col] = "ඞ";
                }

                else if (row % 2 == 0 && col % 2 != 0)
                    board[row][col] = firstChar;

                else
                    board[row][col] = secondChar;
            }
            for (String s : board[row]) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }

    public void reverseByWord() {
        Utility.clearTerminal();

        System.out.println("Give me a sentence!");
        String sentence = s.nextLine();

        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i].toLowerCase();
            words[i] = Utility.reverseIt((words[i]));
            words[i] += i + 1 == words.length ? "" : " ";
        }
        for (String word : words) {
            System.out.print(word);
        }
        System.out.println();
    }
}
