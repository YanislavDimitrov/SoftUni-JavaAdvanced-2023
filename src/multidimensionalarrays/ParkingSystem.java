package multidimensionalarrays;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static boolean[][] parkingLot;
    public static int entryRow;
    public static int targetRow;
    public static int targetCol;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        parkingLot = new boolean[dimensions[0]][];
        populateMatrix(dimensions[1]);

        String input = sc.nextLine();

        while (!input.equals("stop")) {
            int[] inputArgs = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            entryRow = inputArgs[0];
            targetRow = inputArgs[1];
            targetCol = inputArgs[2];
            int distance;

            if (!parkingLot[targetRow][targetCol]) {
                parkingLot[targetRow][targetCol] = true;
                distance = calculateDistance();
            } else {
                int closestCol = getClosestCol();
                if (closestCol == -1) {
                    System.out.printf("Row %d full%n", targetRow);
                    input = sc.nextLine();
                    continue;
                } else {
                    targetCol = closestCol;
                }
                parkingLot[targetRow][targetCol] = true;
                distance = calculateDistance();
            }
            System.out.println(distance);
            input = sc.nextLine();
        }
    }

    private static int getClosestCol() {
        int closestRightIndex = Integer.MAX_VALUE;
        int closestLeftIndex = Integer.MAX_VALUE;

        for (int col = targetCol + 1; col < parkingLot[targetRow].length; col++) {
            if (!parkingLot[targetRow][col]) {
                closestRightIndex = col;
                break;
            }
        }
        for (int col = targetCol - 1; col >= 1; col--) {
            if (!parkingLot[targetRow][col]) {
                closestLeftIndex = col;
                break;
            }
        }
        if (Math.abs(closestLeftIndex - targetCol) < Math.abs(closestRightIndex - targetCol)) {
            return closestLeftIndex;
        } else if (Math.abs(closestRightIndex - targetCol) < Math.abs(closestLeftIndex - targetCol)) {
            return closestRightIndex;
        } else {
            if (closestLeftIndex != Integer.MAX_VALUE) {
                return closestLeftIndex;
            } else {
                return -1;
            }
        }
    }

    private static int calculateDistance() {
        return Math.abs(entryRow - targetRow) + (targetCol + 1);
    }

    private static void populateMatrix(int cols) {

        for (int row = 0; row < parkingLot.length; row++) {
            parkingLot[row] = new boolean[cols];
        }
    }
}
