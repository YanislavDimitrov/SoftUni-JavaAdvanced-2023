package multidimensionalarrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sizeArgs = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = new int[sizeArgs[0]][sizeArgs[1]];
        populateMatrix(sc, matrix);
        int bestSum = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = getCurrentSubmatrixSum(matrix, row, col);
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        System.out.printf("Sum = %d%n", bestSum);
        printSubMatrix(matrix, bestRow, bestCol);
    }

    private static void printSubMatrix(int[][] matrix, int bestRow, int bestCol) {
        for (int row = bestRow; row < bestRow + 3; row++) {
            for (int col = bestCol; col < bestCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int getCurrentSubmatrixSum(int[][] matrix, int startRow, int startCol) {
        int sum = 0;
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
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
