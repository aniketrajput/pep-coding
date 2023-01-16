package com.home.recurssion;

import java.util.Scanner;

public class NQueens {
    public static final Scanner scan = new Scanner(System.in);

    public static void printNQueens() {
        System.out.println("Enter n: ");
        int n = scan.nextInt();

        int[][] chess = new int[n][n];

        displayNQueens(chess, "", 0);
    }

    private static void displayNQueens(int[][] chess, String queenSoFar, int row) {
        if (row == chess.length) {
            System.out.println(queenSoFar);
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (isSafePlaceForQueen(chess, row, col)) {
                chess[row][col] = 1;
                displayNQueens(chess, queenSoFar + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    private static boolean isSafePlaceForQueen(int[][] chess, int row, int col) {
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        return true;
    }


}
