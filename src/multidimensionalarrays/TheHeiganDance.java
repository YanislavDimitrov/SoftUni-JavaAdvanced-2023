package multidimensionalarrays;

import java.util.Scanner;

public class TheHeiganDance {
    public static char[][] field;
    public static int playerRow;
    public static int playerCol;
    public static double playerHitPoints;
    public static double heiganHitPoints;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double heiganDamage = Double.parseDouble(sc.nextLine());
        field = new char[15][15];
        playerRow = 7;
        playerCol = 7;
        playerHitPoints = 18500;
        heiganHitPoints = 3000000;

        loadField();

        String input = sc.nextLine();

        boolean isHeiganAlive = true;
        boolean isPlayerAlive = true;
        boolean hasPendingCloud = false;
        String fatalSpell = "";

        while (isHeiganAlive && isPlayerAlive) {
            heiganHitPoints -= heiganDamage;
            if (hasPendingCloud) {
                playerHitPoints -= 3500;
                hasPendingCloud = false;
            }
            if (heiganHitPoints <= 0 || playerHitPoints <= 0) {
                if (heiganHitPoints <= 0) {
                    isHeiganAlive = false;
                }
                if (playerHitPoints <= 0) {
                    fatalSpell = "Plague Cloud";
                    isPlayerAlive = false;
                }
                continue;
            }
            String[] inputArgs = input.split("\\s+");
            String spell = inputArgs[0];
            int damagedRow = Integer.parseInt(inputArgs[1]);
            int damagedCol = Integer.parseInt(inputArgs[2]);

            damageField(damagedRow, damagedCol);
            //Check if player is inside the Damaged Area
            if (field[playerRow][playerCol] == 'X') {
                if (!playerEscapedSuccessfully()) {
                    if (spell.equals("Cloud")) {
                        playerHitPoints -= 3500;
                        if (playerHitPoints <= 0) {
                            fatalSpell = "Plague Cloud";
                            isPlayerAlive = false;
                            continue;
                        }
                        hasPendingCloud = true;
                    } else {
                        playerHitPoints -= 6000;
                        if (playerHitPoints <= 0) {
                            fatalSpell = "Eruption";
                            isPlayerAlive = false;
                            continue;
                        }
                    }
                }
            }
            loadField();
            input = sc.nextLine();
        }
        if (isHeiganAlive) {
            System.out.printf("Heigan: %.2f%n", heiganHitPoints);
            System.out.printf("Player: Killed by %s%n", fatalSpell);
            System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
        } else if (isPlayerAlive) {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: %.0f%n", playerHitPoints);
            System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
        } else {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: Killed by %s%n", fatalSpell);
            System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
        }


    }

    private static boolean playerEscapedSuccessfully() {
        //Go up,right,down,left
        if (isInside(playerRow - 1, playerCol) && field[playerRow - 1][playerCol] == 'O') {
            playerRow--;
            return true;
        } else if (isInside(playerRow, playerCol + 1) && field[playerRow][playerCol + 1] == 'O') {
            playerCol++;
            return true;
        } else if (isInside(playerRow + 1, playerCol) && field[playerRow + 1][playerCol] == 'O') {
            playerRow++;
            return true;
        } else if (isInside(playerRow, playerCol - 1) && field[playerRow][playerCol - 1] == 'O') {
            playerCol--;
            return true;
        }
        return false;
    }

    private static void damageField(int damagedRow, int damagedCol) {
        for (int row = damagedRow - 1; row <= damagedRow + 1; row++) {
            for (int col = damagedCol - 1; col <= damagedCol + 1; col++) {
                if (isInside(row, col)) {
                    field[row][col] = 'X';
                }
            }
        }
    }

    private static boolean isInside(int row, int col) {
        if (row < 0 || row >= field.length || col < 0 || col >= field[row].length) {
            return false;
        } else return true;
    }

    private static void loadField() {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                field[row][col] = 'O';
            }
        }
    }
}
