package functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class KingsOfHonor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Arrays.stream(sc.nextLine().split("\\s+")).forEach(x -> System.out.println("Sir "+x));
    }
}
