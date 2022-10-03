package Task_2;

public class QuickSort {

    /* Quicksort is the widely used sorting algorithm that makes (n log n) comparisons
        in average case for sorting an array of n elements.*/
    public static void quickSort(int[] arr, int from, int to) {

        if (from < to) {

            int divideIndex = partition(arr, from, to);
            quickSort(arr, from, divideIndex - 1);
            quickSort(arr, divideIndex, to);
        }
    }

    // Separation algorithm
    private static int partition(int[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        // In the given array, we consider the middle element as pivot
        int pivot = arr[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            while (arr[leftIndex] > pivot) {
                leftIndex++;
            }

            while (arr[rightIndex] < pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    // This method swaps the first and second index
    private static void swap(int[] array, int index1, int index2) {
        int tmp  = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
