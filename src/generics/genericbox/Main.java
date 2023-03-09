package generics.genericbox;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Jar<String> jar = new Jar<>();


        for (int i = 0; i < n; i++) {
            jar.addItem(sc.nextLine());
        }
        System.out.print(jar);
    }
}