package multidimensionalarrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = new int[rowsAndCols[0]][rowsAndCols[1]];
        populateMatrix(sc, matrix);
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(getMatrixSum(matrix));
    }

    private static int getMatrixSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
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
