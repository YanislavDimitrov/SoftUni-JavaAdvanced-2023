package stacksandqueues;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static long[] memo = new long[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        long fibonacciNumber = getFibonacci(n+1);
        System.out.println(fibonacciNumber);

    }

    private static long getFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else if (memo[n] != 0) {
            return memo[n];
        } else {
            memo[n] = getFibonacci(n-1) + getFibonacci(n - 2);
            return memo[n];
        }
    }
}
