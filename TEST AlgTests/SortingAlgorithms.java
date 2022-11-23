
import java.util.Arrays;

public class SortingAlgorithms {
    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    // BubbleSort
    public static void bubbleSortRevision(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i])
                    swap(nums, i, j);
            }

        }
        System.out.println(Arrays.toString(nums));
    }

    public static void selectionSortRevision(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int largest = 0;

            // { 20, 35, -15, 7, 55, 1, -22 };

            for (int j = 0; j <= i; j++) {
                if (nums[j] > nums[largest]) {
                    largest = j;
                }

            }
            swap(nums, largest, i);
        }
        System.out.println(Arrays.toString(nums));

    }

    public static void insertionSortRevision(int[] nums) {
        // { 20, 35, -15, 7, 55, 1, -22 };
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < nums.length; firstUnsortedIndex++) {
            int unsortedVal = nums[firstUnsortedIndex];
            int i;

            for (i = firstUnsortedIndex; i > 0 && nums[i - 1] > unsortedVal; i--) {

                nums[i] = nums[i - 1];
            }
            nums[i] = unsortedVal;

        }
        System.out.println(Arrays.toString(nums));

    }

    /*
     * 
     * public static recursiveSortRevision(int[] nums, int unsortedIndex) {
     * int unsortedVal = nums[unsortedIndex];
     * // Logic that inserts the val at correct index position one iteration
     * 
     * 
     * return recursiveSortRevision(updatednumsArr, unsortedIndex++);
     * }
     */
    public static void insertionSortRevisionTest(int[] nums) {
        // { 20, 35, -15, 7, 55, 1, -22 };

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < nums.length; firstUnsortedIndex++) {
            int i;
            int unsortedValue = nums[firstUnsortedIndex];

            for (i = firstUnsortedIndex; i > 0 && nums[i - 1] > unsortedValue; i--) {
                nums[i] = nums[i - 1];
            }

            nums[i] = unsortedValue;

        }
        System.out.println(Arrays.toString(nums));
    }

    public static void shellSortRevision(int[] nums) {
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {
                int unsortedVal = nums[i];

                int j = i;

                // Insertion
                while (j >= gap && nums[j - gap] > unsortedVal) {
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = unsortedVal;

            }

        }
    }

    public static void mergeSort(int[] input, int start, int end) {
        // 1 element arr
        if (end - start < 2) {
            return;
        }

        // Calc mdpt of given arr
        int mid = (start + end) / 2;

        mergeSort(input, start, mid);
        mergeSort(input, mid, end);

        // Merge sibling arr
        merge(input, start, mid, end);
        System.out.println(Arrays.toString(input));

    }

    public static void merge(int[] input, int start, int mid, int end) {
        // If last index of left arr is less than the last most value in the first index
        // then we can just leave the arr alone
        if (input[mid - 1] >= input[mid])
            return;

        int i = start; // Left partition index
        int j = mid; // Right partition index
        int tempIndex = 0; // Preserve insertion index

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            // depending on which value is less, the next index value will be from left or
            // right arr
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];

        }
        // Copy into one arr
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        // Insert into main arr
        System.arraycopy(temp, 0, input, start, tempIndex);

    }

    public static void main(String[] args) {
        int[] input = { 20, 35, -15, 7, 55, 1, -22 };
        // SortingAlgorithms.bubbleSortRevision(input);
        // SortingAlgorithms.selectionSortRevision(input);
        // SortingAlgorithms.insertionSortRevision(input);
        // SortingAlgorithms.insertionSortRevisionTest(input);
        SortingAlgorithms.mergeSort(input, 0, 7);

    }
}
