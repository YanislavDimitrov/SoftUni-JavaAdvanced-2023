package multidimensionalarrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static int[][] matrix;
    public static int[][] result;
    public static int incorrectNumber;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());

        matrix = new int[rows][];
        result = new int[rows][];
        populateMatrix(sc);

        int[] incorrectNumCoordinates = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        incorrectNumber = matrix[incorrectNumCoordinates[0]][incorrectNumCoordinates[1]];

        fixIncorrectNumbers(incorrectNumber);
        System.out.println(printMatrix(result));
    }

    private static void fixIncorrectNumbers(int incorrectNumber) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == incorrectNumber) {
                    result[row][col] = getNewValue(row, col);
                } else {
                    result[row][col] = matrix[row][col];
                }
            }
        }
    }

    private static String printMatrix(int[][] matrix) {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                builder.append(matrix[row][col]).append(" ");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    private static int getNewValue(int row, int col) {
        int sum = 0;
        sum += getElement(row, col - 1);
        sum += getElement(row, col + 1);
        sum += getElement(row - 1, col);
        sum += getElement(row + 1, col);
        return sum;
    }

    private static int getElement(int row, int col) {
        if (isInside(row, col) && matrix[row][col] != incorrectNumber) {
            return matrix[row][col];
        }
        return 0;
    }

    private static boolean isInside(int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
            return false;
        } else return true;
    }

    private static void populateMatrix(Scanner sc) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(sc.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            result[row] = new int[matrix[row].length];
        }
    }
}
