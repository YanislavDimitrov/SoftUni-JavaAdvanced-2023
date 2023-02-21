package multidimensionalarrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        String[][] firstMatrix = new String[rows][cols];
        String[][] secondMatrix = new String[rows][cols];
        String[][] resultMatrix = new String[rows][cols];

        populateMatrix(sc, firstMatrix);
        populateMatrix(sc, secondMatrix);

        populateResultMatrix(firstMatrix, secondMatrix, resultMatrix);

        System.out.println(printMatrix(resultMatrix));
    }

    private static String printMatrix(String[][] matrix) {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                builder.append(matrix[row][col]).append(" ");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    private static void populateResultMatrix(String[][] firstMatrix, String[][] secondMatrix, String[][] resultMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    resultMatrix[row][col] = firstMatrix[row][col];
                } else {
                    resultMatrix[row][col] = "*";
                }
            }
        }
    }

    private static void populateMatrix(Scanner sc, String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = sc.nextLine().split("\\s+");
        }
    }
}
