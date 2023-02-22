package multidimensionalarrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> inputs = new ArrayList<>();
        int cols = 0;
        String command = sc.nextLine();
        int rotation = Integer.parseInt(command.substring(7, command.length() - 1)) % 360;
        String input = sc.nextLine();

        while (!input.equals("END")) {
            if (input.length() > cols) {
                cols = input.length();
            }
            inputs.add(input);
            input = sc.nextLine();
        }
        int rows = inputs.size();
        char[][] matrix = new char[rows][cols];
        populateMatrix(inputs, matrix);

        switch (rotation) {
            case 90:
                System.out.print(print90Degrees(matrix));
                break;
            case 180:
                System.out.print(print180Degrees(matrix));
                break;
            case 270:
                System.out.print(print270Degrees(matrix));
                break;
            default:
                System.out.print(print0Degrees(matrix));
                break;
        }
    }

    private static String print0Degrees(char[][] matrix) {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                builder.append(matrix[row][col]);
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    private static String print270Degrees(char[][] matrix) {
        StringBuilder builder = new StringBuilder();
        for (int col = matrix[0].length - 1; col >= 0; col--) {
            for (int row = 0; row < matrix.length; row++) {
                builder.append(matrix[row][col]);
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    private static String print180Degrees(char[][] matrix) {
        StringBuilder builder = new StringBuilder();
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[0].length - 1; col >= 0; col--) {
                builder.append(matrix[row][col]);
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    private static String print90Degrees(char[][] matrix) {
        StringBuilder builder = new StringBuilder();

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                builder.append(matrix[row][col]);
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    private static void populateMatrix(List<String> inputs, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col >= inputs.get(row).length()) {
                    matrix[row][col] = ' ';
                } else {
                    matrix[row][col] = inputs.get(row).charAt(col);
                }
            }
        }
    }
}
