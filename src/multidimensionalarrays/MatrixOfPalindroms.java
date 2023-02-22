package multidimensionalarrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindroms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sizeArgs = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[sizeArgs[0]][sizeArgs[1]];

        populateMatrix(matrix);
        System.out.println(printMatrix(matrix));
    }

    private static void populateMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String currentElement = getCurrentElement(row, col);
                matrix[row][col] = currentElement;
            }
        }
    }

    private static String getCurrentElement(int row, int col) {
        StringBuilder builder = new StringBuilder();
        char outerCharacters = (char) (97 + row);
        char inner = (char) (97 + row + col);
        builder.append(outerCharacters).append(inner).append(outerCharacters);
        return builder.toString();
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
}
