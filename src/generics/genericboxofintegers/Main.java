package generics.genericboxofintegers;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Jar<Integer> jar = new Jar<>();


        for (int i = 0; i < n; i++) {
            jar.addItem(Integer.parseInt(sc.nextLine()));
        }
        System.out.print(jar);
    }
}