public class InsertionSort {

    static int stepCount = 0;

    static void insertionSort(int[] arr) {
        stepCount = 0;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                stepCount++;              // comparison
                arr[j + 1] = arr[j];      // shift
                j--;
            }
            arr[j + 1] = key;             // insertion
            stepCount++;
        }
    }

    static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {35, 12, 48, 7, 22};

        insertionSort(arr);

        System.out.println("Sorted Array (Insertion Sort):");
        printArray(arr);
        System.out.println("Step Count: " + stepCount);
    }
}
