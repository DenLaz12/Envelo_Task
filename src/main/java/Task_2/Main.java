package Task_2;

public class Main {
    public static void main(String[] args) {

        int[] array = generateArray(30);
        int numberToSearch = 2;

        printResult(array, numberToSearch);
    }

    // This method generates random numbers and writes them to an array
    public static int[] generateArray(int arrayLength){
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    /* I have used Binary Search to find a number. Binary Search is a searching algorithm used in a sorted array
        by repeatedly dividing the search interval in half. The idea of binary search is to use the information
        that the array is sorted and reduce the time complexity to O(Log n) */
    public static boolean search(int[] array, int numberToSearch){

        int firstIndex = 0;
        int lastIndex = array.length - 1;

        // Termination condition (element not present)
        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            // If the middle element is the target element, return its index
            if (array[middleIndex] == numberToSearch) {
                return true;
            }

            // If the middle element is bigger
            // We direct our index to middle+1, removing the first part from consideration
            else if (array[middleIndex] > numberToSearch)
                firstIndex = middleIndex + 1;

                // If the middle element is less
                // We direct our index to middle-1, removing the second part from consideration
            else if (array[middleIndex] < numberToSearch)
                lastIndex = middleIndex - 1;
        }
        return false;
    }

    // This method prints the result to the console
    public static void printResult(int[] array, int numberToSearch){

        QuickSort.quickSort(array, 0, array.length-1);
        System.out.print("Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nIs the number " + numberToSearch + " in Array? " + search(array, numberToSearch));
    }
}
