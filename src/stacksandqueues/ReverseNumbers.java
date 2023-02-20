package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(numbers).forEach(stack::push);
        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
