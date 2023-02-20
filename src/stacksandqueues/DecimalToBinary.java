package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();

        int inputNumber = Integer.parseInt(sc.nextLine());

        if(inputNumber==0){
            System.out.println("0");
            return;
        }

        while (inputNumber > 0) {
            stack.push(inputNumber % 2);
            inputNumber /= 2;
        }
        System.out.println(printStack(stack));
    }

    private static String printStack(Deque<Integer> stack) {
        StringBuilder builder = new StringBuilder();

        for (Integer number : stack) {
            builder.append(number);
        }
        return builder.toString();
    }
}
