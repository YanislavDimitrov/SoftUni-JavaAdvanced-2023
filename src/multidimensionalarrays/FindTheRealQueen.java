package multidimensionalarrays;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 8;
        String[][] chessBoard = new String[size][size];

        populateMatrix(sc, chessBoard);

        for (int row = 0; row < chessBoard.length; row++) {
            for (int col = 0; col < chessBoard.length; col++) {
                if (chessBoard[row][col].equals("q")) {
                    if (isSpecialQueen(chessBoard, row, col)) {
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }

    }

    private static boolean isSpecialQueen(String[][] chessBoard, int row, int col) {
        boolean isVerticalClear = isVerticalClear(chessBoard, col);
        boolean isHorizontalClear = isHorizontalClear(chessBoard, row);
        boolean areDiagonalsClear = areDiagonalsClear(chessBoard, row, col);
        return isVerticalClear && isHorizontalClear && areDiagonalsClear;
    }

    private static boolean areDiagonalsClear(String[][] chessBoard, int row, int col) {
        return isTopDiagonalClear(chessBoard, row, col) && isBottomDiagonalClear(chessBoard, row, col);
    }

    private static boolean isBottomDiagonalClear(String[][] chessBoard, int startRow, int startCol) {

        for (int row = startRow - 1, col = startCol + 1; row >= 0 && col < chessBoard.length; row--, col++) {
            if (chessBoard[row][col].equals("q")) {
                return false;
            }
        }
        for (int row = startRow + 1, col = startCol - 1; row < chessBoard.length && col >= 0; row++, col--) {
            if (chessBoard[row][col].equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static boolean isTopDiagonalClear(String[][] chessBoard, int startRow, int startCol) {
        for (int row = startRow - 1, col = startCol - 1; row >= 0 && col >= 0; row--, col--) {
            if (chessBoard[row][col].equals("q")) {
                return false;
            }
        }
        for (int row = startRow + 1, col = startCol + 1; row < chessBoard.length && col < chessBoard.length; row++, col++) {
            if (chessBoard[row][col].equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static boolean isHorizontalClear(String[][] chessBoard, int row) {
        int countOfQueens = 0;

        for (int col = 0; col < chessBoard.length; col++) {
            if (chessBoard[row][col].equals("q")) {
                countOfQueens++;
            }
        }
        return countOfQueens == 1;
    }

    private static boolean isVerticalClear(String[][] chessBoard, int col) {
        int countOfQueens = 0;

        for (int row = 0; row < chessBoard.length; row++) {
            if (chessBoard[row][col].equals("q")) {
                countOfQueens++;
            }
        }
        return countOfQueens == 1;
    }

    private static void populateMatrix(Scanner sc, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = sc.nextLine()
                    .split("\\s+");
        }
    }
}
