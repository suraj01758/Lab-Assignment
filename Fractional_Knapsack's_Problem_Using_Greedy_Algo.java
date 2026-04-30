import java.util.*;
class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    static double fractionalKnapsack(int W, Item[] arr, int n) {

        // Sort by value/weight ratio (descending)
        Arrays.sort(arr, (a, b) -> {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1);
        });

        double totalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (W >= arr[i].weight) {
                W -= arr[i].weight;
                totalValue += arr[i].value;
            } else {
                totalValue += arr[i].value * ((double) W / arr[i].weight);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, W;

        // Restrict number of items < 4
        do {
            System.out.print("Enter number of items (<4): ");
            n = sc.nextInt();
        } while (n <= 0 || n >= 4);

        Item[] arr = new Item[n];

        System.out.println("Enter value and weight of each item:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            int weight = sc.nextInt();

            if (weight <= 0) {
                System.out.println("Invalid weight! Re-enter:");
                i--;
                continue;
            }

            arr[i] = new Item(value, weight);
        }

        System.out.print("Enter capacity of knapsack: ");
        W = sc.nextInt();

        double result = fractionalKnapsack(W, arr, n);

        System.out.println("Maximum value = " + result);

        sc.close();
    }
}
