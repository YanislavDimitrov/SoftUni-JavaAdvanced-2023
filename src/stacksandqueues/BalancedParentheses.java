package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String openBraces = "([{";
        Deque<Character> stack = new ArrayDeque<>();
        String input = sc.nextLine();

        boolean areBalanced = true;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (openBraces.contains(String.valueOf(input.charAt(i)))) {
                stack.push(input.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    areBalanced = false;
                    break;
                }

                char popped = stack.pop();

                if (popped == '(' && current != ')') {
                    areBalanced = false;
                    break;
                } else if (popped == '{' && current != '}') {
                    areBalanced = false;
                    break;
                } else if (popped == '[' && current != ']') {
                    areBalanced = false;
                    break;
                }
            }
        }
        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
