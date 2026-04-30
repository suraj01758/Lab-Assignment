import java.util.concurrent.ThreadLocalRandom; 

import java.util.Scanner; 

public class LinearSearch { 

    public static void main(String[] args) { 

        Scanner sc = new Scanner(System.in); 

        int[] arr = new int[5]; 

        System.out.println("enter array element: "); 

        for(int i=0; i<arr.length; i++) { 

            arr[i] = sc.nextInt(); 

        } 

        System.out.println("\nArray elements"); 

        for(int i=0; i<arr.length; i++) { 

            System.out.print(i + " "); 

        } 

        System.out.println("\nLinear Search"); 

        linearSearch(arr, 20); 

    } 

    public static void linearSearch(int[] arr, int target) { 

        boolean isFound = false; 

        for(int i=0; i<arr.length; i++) { 

            if(arr[i] == target) { 

                System.out.println("element found on: " + arr[i]); 

                isFound = true; 

                break; 

            } 

        } 

        if(!isFound) System.out.println("element not found in list!"); 

    } 

} 
