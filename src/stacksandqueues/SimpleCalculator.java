package stacksandqueues;

import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Deque<String> stack = new ArrayDeque<>();

        String[] input = sc.nextLine().split("\\s+");
        Collections.reverse(Arrays.asList(input));

        populateStack(stack, input);
        int currentSum;

        while (stack.size() > 1) {

            int leftNumber = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            int rightNumber = Integer.parseInt(stack.pop());

            currentSum = operand.equals("+")
                    ? leftNumber + rightNumber
                    : leftNumber - rightNumber;

            stack.push("" + currentSum);
        }
        System.out.println(stack.peek());
    }

    private static void populateStack(Deque<String> stack, String[] input) {
        for (String s : input) {
            stack.push(s);
        }
    }
}
