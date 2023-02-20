package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            int[] command = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int commandType = command[0];

            switch (commandType) {
                case 1:
                    stack.push(command[1]);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(getMax(stack));
                    break;
            }
        }
    }

    private static int getMax(Deque<Integer> stack) {
        int result = Integer.MIN_VALUE;

        for (Integer integer : stack) {
            if (integer > result) {
                result = integer;
            }
        }
        return result;
    }
}
