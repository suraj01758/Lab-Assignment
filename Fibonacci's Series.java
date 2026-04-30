public class Fibonacci { 
    static int stepCount = 0; 

   # Iterative Fibonacci 

    static void fibIterative(int n) { 
        stepCount = 0; 

        int a = 0, b = 1; 

        System.out.print(a + " " + b + " "); 

        for (int i = 2; i < n; i++) { 

            int c = a + b; 

            System.out.print(c + " "); 

            a = b; 

            b = c; 

            stepCount++; 

        } 

        System.out.println("\nStep Count: " + stepCount); 

    } 

    #Recursive Fibonacci 

    static int fibRecursive(int n) { 

        stepCount++; 

        if (n <= 1) 

            return n; 

        return fibRecursive(n - 1) + fibRecursive(n - 2); 

    } 

    public static void main(String[] args) { 

        int n = 6; 

        fibIterative(n); 

 

        stepCount = 0; 

        System.out.println("Recursive Fibonacci: " + fibRecursive(n)); 

        System.out.println("Step Count: " + stepCount); 

    } 

} 
