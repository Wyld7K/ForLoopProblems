package AlgTests;

import java.util.Arrays;

public class SortingAlg {

    // assume that range is 1-10
    public static void countingSort(int[] input, int min, int max) {
        int[] countArr = new int[(max - min) + 1];

        // Fills count arr
        for (int i = 0; i < input.length; i++) {

            countArr[input[i] - min]++;
        }

        int j = 0;

        for (int i = min; i <= max; i++) {
            while (countArr[i - min] > 0) {
                input[j++] = i;

                // Decrements num count at index position
                countArr[i - min]--;
            }

        }

        System.out.println(Arrays.toString(input));

    }

    public static void countSrtPractice(int input[], int min, int max) {
        // Fill count arr
        // 1-10

        int[] countArr = new int[(max - min) + 1];

        for (int i = 0; i < input.length; i++) {
            countArr[(input[i] - min)]++;
        }

        // Take values at pos of countArr and fill them into input arr

        // { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 }
        int j = 0;

        for (int i = min; i <= max; i++) {
            while (countArr[i - min] > 0) {
                input[j++] = i;

                countArr[i - min]--;
            }

        }

        System.out.println(Arrays.toString(input));

    }

    public static void countSrtTest(int input[], int min, int max) {
        int countArr[] = new int[(max - min) + 1];
        for (int i = 0; i < countArr.length; i++) {
            countArr[input[i] - min]++;
        }

        int j = 0;

        for (int i = min; i <= max; i++) {
            // { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };

            while (countArr[i - min] > 0) {
                input[j++] = i;
                countArr[i - min]--;
            }
            // Fill count arr

            //
        }
        // Fill count arr
        System.out.println(Arrays.toString(input));
    }

    // RADIX SORT UNFINISHED
    public static void radixSort(int input[], int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
            System.out.println(Arrays.toString(input));
        }

    }

    public static void radixSingleSort(int[] input, int pos, int radix) {
        int numItems = input.length;

        int[] countArr = new int[radix];

        // Count arr
        for (int value : input) {
            countArr[getDigit(pos, value, radix)]++;
        }

        // Adjust count arr
        for (int j = 1; j < radix; j++) {
            countArr[j] += countArr[j - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems; tempIndex >= 0; tempIndex--) {
            temp[--countArr[getDigit(pos, input[tempIndex], radix)]] = input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    public static int getDigit(int pos, int val, int radix) {
        return val / (int) Math.pow(radix, pos) % radix;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };
        int[] radixArr = { 4725, 4586, 1330, 8792, 1594, 5729 };

        // SortingAlg.countingSort(nums, 1, 10);
        // SortingAlg.countSrtPractice(nums, 1, 10);
        // SortingAlg.countSrtTest(nums, 1, 10);
        // SortingAlg.radixSort(radixArr, 10, 4);
        ;
    }

}
