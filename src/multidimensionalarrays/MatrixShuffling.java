package multidimensionalarrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sizeArgs = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] matrix = new String[sizeArgs[0]][sizeArgs[1]];

        populateMatrix(sc, matrix);

        String input = sc.nextLine();

        while (!input.equals("END")) {
            String[] inputArgs = input.split("\\s+");

            if (inputArgs.length != 5 || !inputArgs[0].equals("swap")) {
                System.out.println("Invalid input!");
                input = sc.nextLine();
                continue;
            }
            int firstElementRow = Integer.parseInt(inputArgs[1]);
            int firstElementCol = Integer.parseInt(inputArgs[2]);
            int secondElementRow = Integer.parseInt(inputArgs[3]);
            int secondElementCol = Integer.parseInt(inputArgs[4]);

            if (!isInside(firstElementRow, firstElementCol, matrix)
                    || !isInside(secondElementRow, secondElementCol, matrix)) {
                System.out.println("Invalid input!");
                input = sc.nextLine();
                continue;
            }

            String temp = matrix[firstElementRow][firstElementCol];
            matrix[firstElementRow][firstElementCol] = matrix[secondElementRow][secondElementCol];
            matrix[secondElementRow][secondElementCol] = temp;

            System.out.print(printMatrix(matrix));
            input = sc.nextLine();
        }


    }

    private static void populateMatrix(Scanner sc, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = sc.nextLine()
                    .split("\\s+");
        }
    }

    private static boolean isInside(int row, int col, String[][] matrix) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
            return false;
        } else return true;
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
