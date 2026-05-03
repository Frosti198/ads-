import java.util.Scanner;

public class assigment1 {
    
    // Task 1: Sum of the squares
    public static int sumOfSquares(int n) {
        if (n == 1) return 1;
        return (n * n) + sumOfSquares(n - 1);
    }

    // Task 2: Sum of the first n elements of an array
    public static int sumOfArray(int[] arr, int n) {
        if (n <= 0) return 0;
        return arr[n - 1] + sumOfArray(arr, n - 1);
    }

    // Task 3: Sum of the first n powers of a base b
    public static int sumOfPowers(int b, int n) {
        if (n == 0) return 1;
        return (int) Math.pow(b, n) + sumOfPowers(b, n - 1);
    }

    // Task 4: Display sequence in reverse order (no loops, no arrays)
    public static void reverseInput(Scanner sc, int n) {
        if (n == 0) return;
        int current = sc.nextInt();
        reverseInput(sc, n - 1);
        System.out.print(current + " ");
    }

    public static void main(String[] args) {
    }
}
