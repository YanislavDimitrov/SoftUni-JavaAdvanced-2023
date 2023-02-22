package multidimensionalarrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[dimensions[0]][dimensions[1]];

        populateMatrix(sc, matrix);
        StringBuilder builder = new StringBuilder();
        for (int col = matrix[matrix.length - 1].length; col >= 0; col--) {
            builder.append(getDiagonal(matrix, matrix.length - 1, col)).append(System.lineSeparator());
        }
        for (int row = matrix.length - 2; row >= 0; row--) {
            builder.append(getDiagonal(matrix, row, 0)).append(System.lineSeparator());
        }
        System.out.println(builder.toString());
    }

    private static String getDiagonal(int[][] matrix, int startRow, int startCol) {
        StringBuilder builder = new StringBuilder();
        for (int row = startRow, col = startCol; row >= 0 && col < matrix[row].length; row--, col++) {
            builder.append(matrix[row][col]).append(" ");
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

    private static boolean isInside(int row, int col, int[][] matrix) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
            return false;
        } else return true;
    }
}
