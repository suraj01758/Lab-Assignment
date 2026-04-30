public class BinarySearch {

    static int stepCount = 0;

    // =========================
    // Iterative Binary Search
    // =========================
    static int binarySearchIterative(int[] arr, int key) {
        stepCount = 0;

        int low = 0;
        int high = arr.length - 1;
 
        while (low <= high) {
            stepCount++;   // counting comparison step

            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;  // not found
    }

    // =========================
    // Recursive Binary Search
    // =========================
    static int binarySearchRecursive(int[] arr, int low, int high, int key) {
        stepCount++;  // counting each recursive call

        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == key)
            return mid;
        else if (arr[mid] < key)
            return binarySearchRecursive(arr, mid + 1, high, key);
        else
            return binarySearchRecursive(arr, low, mid - 1, key);
    }

    // =========================
    // Main Method
    // =========================
    public static void main(String[] args) {

        int[] arr = {7, 12, 22, 35, 48};   // MUST be sorted
        int key = 22;

        // Iterative Search
        int result1 = binarySearchIterative(arr, key);

        if (result1 != -1)
            System.out.println("Iterative: Element found at index " + result1);
        else
            System.out.println("Iterative: Element not found");

        System.out.println("Step Count (Iterative): " + stepCount);

        // Recursive Search
        stepCount = 0;
        int result2 = binarySearchRecursive(arr, 0, arr.length - 1, key);

        if (result2 != -1)
            System.out.println("Recursive: Element found at index " + result2);
        else
            System.out.println("Recursive: Element not found");

        System.out.println("Step Count (Recursive): " + stepCount);
    }
}
