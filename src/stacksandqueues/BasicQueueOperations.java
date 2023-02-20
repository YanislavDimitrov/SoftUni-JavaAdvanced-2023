package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] inputArgs = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int queueSize = inputArgs[0];
        int elementsCount = inputArgs[1];
        int specialNumber = inputArgs[2];

        Deque<Integer> queue = new ArrayDeque<>(queueSize);
        queue.addAll(Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));

        for (int i = 0; i < elementsCount; i++) {
            queue.poll();
        }
        if (queue.contains(specialNumber)) {
            System.out.println(true);
        } else {
            if (queue.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(getSmallestNumber(queue));
            }
        }
    }

    private static int getSmallestNumber(Deque<Integer> queue) {
        int smallestNumber = Integer.MAX_VALUE;

        for (Integer number : queue) {
            if (number < smallestNumber) {
                smallestNumber = number;
            }
        }
        return smallestNumber;
    }
}
