package multidimensionalarrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputArgs = Arrays.stream(sc.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = inputArgs[0];
        int cols = inputArgs[1];

        int[][] firstMatrix = new int[rows][cols];

        populateMatrix(sc, firstMatrix);

        inputArgs = Arrays.stream(sc.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        rows = inputArgs[0];
        cols = inputArgs[1];

        int[][] secondMatrix = new int[rows][cols];

        populateMatrix(sc, secondMatrix);

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length
                || firstMatrix[0].length != secondMatrix[0].length) {
            return false;
        } else {
            for (int row = 0; row < firstMatrix.length; row++) {
                for (int col = 0; col < firstMatrix[row].length; col++) {
                    if (firstMatrix[row][col] != secondMatrix[row][col]) {
                        return false;
                    }
                }
            }
        }
        return true;
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
