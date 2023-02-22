package multidimensionalarrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[size][size];

        populateMatrix(sc, matrix);

        int firstDiagSum = getFirstDiagSum(matrix);
        int secondDiagSum = getSecondDiagSum(matrix);
        System.out.println(Math.abs(firstDiagSum - secondDiagSum));

    }

    private static int getSecondDiagSum(int[][] matrix) {
        int sum = 0;
        for (int row = matrix.length - 1, col = 0; row >= 0; row--, col++) {
            sum += matrix[row][col];
        }
        return sum;
    }

    private static int getFirstDiagSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][row];
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
