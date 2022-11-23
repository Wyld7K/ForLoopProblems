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
    Scanner s;

    // constructor:
    public ForLoops(Scanner sc) {
        s = sc; // save Scanner sent from runner so it can be used in this class

    }

    /**
     * Precondition: None
     * PostCondition: Prints the number of vowels
     * 
     */
    public void countVowels() {
        Utility.clearTerminal();

        int vowelCount = 0;
        List<Character> vowels = new ArrayList<Character>(Arrays.asList(new Character[] { 'A', 'E', 'I', 'O', 'U' }));

        System.out.println("Please Give Me A Word!");
        String word = s.nextLine();

        for (int i = 0; i < word.length(); i++) { // count num vowels in string
            if (vowels.contains((word.toUpperCase().charAt(i)))) {
                vowelCount++;
            }

        }
        Utility.printSleepDotsMessage("Number of Vowels: " + vowelCount, "Calculating"); // Print formatted msg

    }

    /**
     * Precondition: None
     * PostCondition: Prints the reversed String
     * 
     */

    public void reverseIt() {
        Utility.clearTerminal();

        System.out.println("Please give me a sentence or word and I will reverse it!");
        String word = s.nextLine();

        String tempWord = ""; // Stores reversed word

        for (int i = word.length() - 1; i >= 0; i--) { // Left-to-right iteration of String via charAt()
            tempWord += word.charAt(i);
        }
        System.out.println(tempWord);

    }

    /**
     * Precondition: None
     * PostCondition: Prints the reversed String
     * 
     * Sorts letters of string in alphebetical order
     */
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

    /**
     * Precondition: None
     * PostCondition: Prints the reversed String
     * 
     * Prints checkerboard fo X0 Board
     */
    public void showBoard() {
        Utility.clearTerminal();
        System.out.println("Give me your desired dimensions");
        String[][] board = new String[10][10];

        // Every even row
        // Every odd col
        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[row].length; col++) {
                if (row % 2 == 0)
                    // if (row % 2 == 0 && col % 2 != 0)
                    if (col % 2 == 0)
                        board[row][col] = "X";
                    else
                        board[row][col] = "O";
                else {
                    if (col % 2 == 0)
                        board[row][col] = "O";
                    else
                        board[row][col] = "X";
                }

            }
            for (String s : board[row]) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }

    /**
     * Precondition: None
     * PostCondition: Prints the all prime between min & mix
     * 
     * Calc and print primes
     */
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
            } else
                System.out.println("Prime Number: " + num);

        }
        System.out.println("Scroll up to see prime numbers");
        Utility.sleepThread(4);

    }

    /**
     * Precondition: None
     * PostCondition: Int guessing game
     */
    public void guessingGame() {
        Utility.clearTerminal();

        int money = 1000;
        int randomStart = ((int) (Math.random() * 1000) + 1);
        int randomEnd = (int) ((Math.random() * 1000) + randomStart);
        int chosenNum = 0;
        int betAmount = 0;
        int numGuesses = 0;
        boolean isPlaying = true;

        while (isPlaying) {
            randomStart = ((int) (Math.random() * 1000) + 1);
            randomEnd = (int) ((Math.random() * 1000) + randomStart);

            while (randomStart > chosenNum && randomEnd > chosenNum)
                chosenNum = (int) (Math.random() * randomEnd);

            System.out.println("CHOSEN NUM: " + chosenNum);

            do {
                System.out.println("Please Place Your Bet💸, You start with $1000! ");
                betAmount = s.nextInt();
            } while (betAmount > money && money > 0);

            System.out.println("The range is from " + randomStart + " - " + randomEnd);

            System.out.println("You have 9 guesses!");
            Utility.sleepThread(2);
            System.out.println("Please Give me your guess❔");

            int guess = s.nextInt();
            int firstShortendRange = (randomStart + (randomEnd - chosenNum) / 2); // 1st shortend range (hint)
            int secondShortendRange = (chosenNum + (randomEnd - chosenNum) / 2); // 2nd shortend range (hint)

            while (guess != chosenNum && numGuesses != 9) {

                if (numGuesses == 3) {
                    System.out.println("Here's a hint");
                    Utility.sleepThread(1);
                    System.out.println("The number is greater than " + firstShortendRange);

                }
                if (numGuesses == 6) {
                    System.out.println("Here's a hint");
                    System.out.println("The number is lower than " + secondShortendRange);
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

            if (numGuesses == 9 && money - betAmount != 0) {
                System.out.println("Sorry you lose, but still have money to play!");
                money -= betAmount;
                System.out.println("Remaining money $" + money);

            } else if (money - betAmount == 0) {
                System.out.println("Sorry you have lost the game!");
                return;
            } else {
                money += betAmount;
                System.out.println("That's Correct!");
                System.out.println("Remaining Money: $" + money);
            }

            isPlaying = Utility.YayOrNay(); // Play again?

            Utility.clearTerminal(); // Clear terminal for next game

        }
    }

    /**
     * Sorts an arr of nums and explains what each one is doing!
     */
    public void yourOwn() {
        System.out.println("This is a merge sort algorithm, sorts in descending order");
        int nums[] = { 20, 35, -15, 7, 55, 1, -22 };
        Utility.mergeSort(nums, 0, 7);

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

    /**
     * Precondition: None
     * PostCondition: Prints fancy board
     */
    public void showFancyBoard() {
        Utility.clearTerminal();

        System.out.println("Please give me the dimensions of the board!");
        int dimensions = s.nextInt();
        String[][] board = new String[dimensions][dimensions];
        String firstChar, secondChar = "";

        // I used a doWhile b/c it doesn't get enough love X0X0 dowhile
        // jk lol it's just worse than while and for loops

        // Ensure one character for each cell
        do {
            s.nextLine();
            System.out.println("Please type a single character on the keyboard");
            firstChar = s.nextLine().substring(0);

            System.out.println("Please type ANOTHER😊 single character on the keyboard");
            secondChar = s.nextLine().substring(0);

        } while (firstChar.length() > 1 || secondChar.length() > 1);

        // 2D Arr Iteration
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

    /**
     * Precondition: None
     * Precondition: Prints reversed word
     */
    public void reverseByWord() {
        Utility.clearTerminal();

        System.out.println("Give me a sentence!");
        String sentence = s.nextLine();

        String[] words = sentence.split("\\s+"); // splits on spaces
        for (int i = 0; i < words.length; i++) {
            words[i].toLowerCase();
            words[i] = Utility.reverseIt((words[i]));
            words[i] += i + 1 == words.length ? "" : " "; // If it at the end don't add space
        }
        for (String word : words) {
            System.out.print(word);
        }
        System.out.println();
    }
}
