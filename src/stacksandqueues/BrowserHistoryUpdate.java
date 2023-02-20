package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Deque<String> stackPrevious = new ArrayDeque<>();
        Deque<String> stackNext = new ArrayDeque<>();

        String input = sc.nextLine();

        String currentPage = "";
        while (!input.equals("Home")) {

            if (input.equals("forward")) {
                if (stackNext.size() > 0) {
                    stackPrevious.push((stackNext.pop()));
                    System.out.println(stackPrevious.peek());
                }else{
                    stackNext.clear();
                    System.out.println("no next URLs");
                }
            } else if (input.equals("back")) {
                if (stackPrevious.size() > 1) {
                    stackNext.push(stackPrevious.pop());
                    System.out.println(stackPrevious.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                stackPrevious.push(input);
                stackNext.clear();
                System.out.println(stackPrevious.peek());
            }

            input = sc.nextLine();
        }
    }
}
