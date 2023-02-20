package stacksandqueues;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MathPotato {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PriorityQueue<String> queue = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toCollection(PriorityQueue::new));
        int n = Integer.parseInt(sc.nextLine());

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle)) {
                System.out.printf("Prime %s%n", queue.peek());
            } else {
                System.out.printf("Removed %s%n", queue.poll());
            }
            cycle++;
        }
        System.out.printf("Last is %s", queue.poll());
    }

    private static boolean isPrime(int cycle) {
        if (cycle <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0)
                return false;
        }
        return true;
    }
}
