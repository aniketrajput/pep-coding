package com.home.recurssion_backtracting_level_1;

import java.util.Scanner;

public class KnightTour {

    public static final Scanner scan = new Scanner(System.in);

    public static void printKnightTour() {
        System.out.println("Enter n: ");
        int n = scan.nextInt();
        System.out.println("Enter start position row: ");
        int row = scan.nextInt();
        System.out.println("Enter start position column: ");
        int col = scan.nextInt();

        int[][] chess = new int[n][n];

        displayKnightTour(chess, row, col, 1);
    }

    private static void displayKnightTour(int[][] chess, int row, int col, int moveNo) {
        if (row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] > 0) {
            return;
        } else if (moveNo == chess.length * chess.length) {
            chess[row][col] = moveNo;       //insert last move in chess board
            displayBoard(chess);
            chess[row][col] = 0;            //remove last move once board is displayed
            return;
        }

        chess[row][col] = moveNo;
        displayKnightTour(chess, row - 2, col + 1, moveNo + 1);
        displayKnightTour(chess, row - 1, col + 2, moveNo + 1);
        displayKnightTour(chess, row + 1, col + 2, moveNo + 1);
        displayKnightTour(chess, row + 2, col + 1, moveNo + 1);
        displayKnightTour(chess, row + 2, col - 1, moveNo + 1);
        displayKnightTour(chess, row + 1, col - 2, moveNo + 1);
        displayKnightTour(chess, row - 1, col - 2, moveNo + 1);
        displayKnightTour(chess, row - 2, col - 1, moveNo + 1);
        chess[row][col] = 0;
    }

    private static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
