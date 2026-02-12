package Graphs;

import java.util.Arrays;

public class FloodFill {
    static int[][] grid;

    public static int[][] floodFill(int [][] inputGrid, int sr, int sc, int color){
        if(inputGrid == null || inputGrid.length == 0 || inputGrid[sr][sc] == color){
            return inputGrid;
        }
        if(inputGrid[sr][sc] == color){
            return inputGrid;
        }
        grid = inputGrid;
        int originalColor = grid[sr][sc];

       sink(sr, sc, originalColor, color);

        return grid;
    }

    public static void sink(int row, int col, int originalColor, int color){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != originalColor){
            return;
    }

    grid [row][col] = color;
    sink(row + 1, col , originalColor, color);
    sink(row -1 , col , originalColor, color);
    sink(row, col + 1, originalColor, color);
    sink(row, col -1 , originalColor, color);
}

public static void main(String args[]){
    int grid[][] = {{1,1,1},{1,1,0},{1,0,1}};
    int sr = 1;
    int sc = 1;
    int color = 2;
    int result[][] = floodFill(grid, sr, sc, color);
    System.out.println("Flood fill result: " + Arrays.deepToString(result));
}
}


