package multidimensionalarrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rowsAndCols = Arrays.stream(sc.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = new int[rowsAndCols[0]][rowsAndCols[1]];

        populateMatrix(sc, matrix);

        int specialNum = Integer.parseInt(sc.nextLine());
        boolean hasSpecialNum = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == specialNum) {
                    System.out.println(row + " " + col);
                    hasSpecialNum = true;
                }
            }
        }
        if (!hasSpecialNum) {
            System.out.println("not found");
        }
    }

    private static void populateMatrix(Scanner sc, int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(sc.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
