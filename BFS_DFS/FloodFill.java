package BFS_DFS;

import java.util.Arrays;

public class FloodFill {

    static int grid[][];

    public static void main(String args[]){
        grid = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color =2 ;
        int result[][] = floodFill(grid, sr, sc, color);
        System.out.println("Flood fill result: " + Arrays.deepToString(result));
    }

    public static int[][] floodFill(int inputGrid[][], int startRow, int startCol , int color){

        if(inputGrid == null || inputGrid.length ==0 || inputGrid[startRow][startCol] == color){return inputGrid;}

        int grid[][] = inputGrid;
        int originalColor = grid[startRow][startCol];
        sink(startRow, startCol, originalColor, color);
        return grid;
    }

    public static void sink(int row, int col, int originalColor, int color){
        if(row < 0 || col <0  || row >=grid.length  || col >=grid[0].length || grid[row][col] != originalColor){
            return;
        }
        grid[row][col] = color;
        sink(row +1 , col , originalColor, color);
        sink(row -1 , col , originalColor, color);
        sink(row, col + 1, originalColor, color);
        sink(row, col -1 , originalColor, color);
    }
}
