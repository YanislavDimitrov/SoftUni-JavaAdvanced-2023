package generics.genericcount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> items = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            items.add((sc.nextLine()));
        }
        System.out.println(Box.getHigherItemsCount(items,sc.nextLine()));
    }
}