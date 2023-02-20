package stacksandqueues;

import java.util.*;

public class InfixToPostfix {
    public static String lowPrecedenceOperators = "+-";
    public static String highPrecedenceOperators = "/*";
    public static String brackets = "()";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Deque<String> stack = new ArrayDeque<>();
        Deque<String> queue = new ArrayDeque<>();
        String[] input = sc.nextLine().split("\\s+");
        Map<String, Integer> operators = new HashMap<>();
        populateMap(operators);

        for (int i = 0; i < input.length; i++) {
            String current = input[i];

            if (Character.isDigit(current.charAt(0)) || Character.isLetter(current.charAt(0))) {
                queue.offer(current);

                //Checking if it is an operator
            } else if (operators.containsKey(current)) {
                while (!stack.isEmpty()
                        && operators.containsKey(stack.peek())
                        && operators.get(current) <= operators.get(stack.peek())) {
                    queue.offer(stack.pop());
                }
                stack.push(current);
            } else if (brackets.contains(String.valueOf(current))) {
                if (current.equals("(")) {
                    stack.push(current);
                } else {
                    while (!stack.isEmpty()
                            && !stack.peek().equals("(")) {
                        queue.offer(stack.pop());
                    }
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        for (String character : queue) {
            System.out.print(character + " ");
        }
        System.out.println();
    }

    private static void populateMap(Map<String, Integer> operators) {
        operators.put("+", 0);
        operators.put("-", 0);
        operators.put("*", 1);
        operators.put("/", 1);
    }
}
