package multidimensionalarrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inputArgs = sc.nextLine().split(", ");

        int size = Integer.parseInt(inputArgs[0]);
        String fillType = inputArgs[1];

        int[][] matrix = new int[size][size];

        if (fillType.equals("A")) {
            populateA(matrix);
        } else {
            populateB(matrix);
        }
        System.out.println(printMatrix(matrix));
    }

    private static void populateB(int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }

    private static void populateA(int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter;
                counter++;
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
}
