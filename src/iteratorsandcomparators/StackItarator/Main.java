package iteratorsandcomparators.StackItarator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        String input = sc.nextLine();

        while (!input.equals("END")) {

            if (input.contains("Push")) {
                List<Integer> elementsToPush = Arrays.stream(input.substring(5).split(", ")).map(Integer::parseInt).collect(Collectors.toList());
                stack.push(elementsToPush);

            } else {
                try {
                    stack.pop();
                }catch (UnsupportedOperationException e){
                    System.out.println(e.getMessage());
                }
            }

            input = sc.nextLine();
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}