package com.home.recurssionbacktracting;

import java.util.Scanner;

public class FloodFill {
    public static final Scanner scan = new Scanner(System.in);

    public static void printFloodFillPaths() {
        System.out.println("Enter number of rows: ");
        int n = scan.nextInt();
        System.out.println("Enter number of columns: ");
        int m = scan.nextInt();

        int[][] arr = new int[n][m];

        System.out.println("Enter array elements: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        boolean[][] visited = new boolean[n][m];

        displayFloodFillPaths(arr, 0, 0, "", visited);
    }

    private static void displayFloodFillPaths(int[][] maze, int row, int col, String pathSoFar, boolean[][] visited) {
        if (row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1 || visited[row][col] == true) {
            return;
        }

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(pathSoFar);
            return;
        }

        visited[row][col] = true;
        displayFloodFillPaths(maze, row - 1 , col, pathSoFar + "t", visited);
        displayFloodFillPaths(maze, row , col - 1, pathSoFar + "l", visited);
        displayFloodFillPaths(maze, row + 1 , col, pathSoFar + "d", visited);
        displayFloodFillPaths(maze, row , col + 1, pathSoFar + "r", visited);
        visited[row][col] = false;
    }

}
