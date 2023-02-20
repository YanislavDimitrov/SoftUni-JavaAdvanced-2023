package stacksandqueues;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] inputArgs = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> stack = new ArrayDeque<>(inputArgs[0]);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(numbers);
        stack.addAll(numbers);


        for (int i = 0; i < inputArgs[1]; i++) {
            stack.pop();
        }

        if (stack.contains(inputArgs[2])) {
            System.out.println(true);
        } else {
            if (stack.size() == 0) {
                System.out.println(0);
            } else {
                System.out.println(getSmallestNumber(stack));
            }
        }
    }

    private static int getSmallestNumber(Deque<Integer> stack) {
        int result = Integer.MAX_VALUE;

        for (Integer integer : stack) {
            if (integer < result) {
                result = integer;
            }
        }
        return result;
    }
}
