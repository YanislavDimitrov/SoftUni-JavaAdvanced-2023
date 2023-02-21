package multidimensionalarrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[rowsAndCols[0]][rowsAndCols[1]];
        populateMatrix(sc, matrix);

        int maxSum = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = getSubMatrixSum(matrix, row, col);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        System.out.println(getBestSubmatrix(matrix, bestRow, bestCol));
        System.out.println(maxSum);
    }

    private static String getBestSubmatrix(int[][] matrix, int bestRow, int bestCol) {
        StringBuilder builder = new StringBuilder();

        builder.append(matrix[bestRow][bestCol]).append(" ").append(matrix[bestRow][bestCol + 1]).append(System.lineSeparator())
                .append(matrix[bestRow + 1][bestCol]).append(" ").append(matrix[bestRow + 1][bestCol+1]);

        return builder.toString();
    }

    private static int getSubMatrixSum(int[][] matrix, int row, int col) {
        return matrix[row][col] +
                matrix[row + 1][col] +
                matrix[row][col + 1] +
                matrix[row + 1][col + 1];
    }

    private static void populateMatrix(Scanner sc, int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(sc.nextLine()
                            .split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
