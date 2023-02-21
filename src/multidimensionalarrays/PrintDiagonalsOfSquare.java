package multidimensionalarrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[size][size];
        populateMatrix(sc, matrix);

        System.out.println(getFirstDiagonal(matrix));
        System.out.println(getSecondDiagonal(matrix));
    }

    private static String getSecondDiagonal(int[][] matrix) {
        StringBuilder builder = new StringBuilder();

        for (int row = matrix.length - 1, col = 0; row >= 0; row--, col++) {
            builder.append(matrix[row][col]).append(" ");
        }
        return builder.toString();
    }

    private static String getFirstDiagonal(int[][] matrix) {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            builder.append(matrix[row][row]).append(" ");
        }
        return builder.toString();
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
