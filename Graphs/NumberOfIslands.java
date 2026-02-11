package Graphs;

public class NumberOfIslands {

    static char grid[][];

    public static int numsIslands(char inputGrid[][]){

        if(inputGrid == null || inputGrid.length == 0){
            return 0;
        }

        grid = inputGrid;
        int count = 0;

        for(int r = 0 ; r < grid.length; r++){
            for(int c = 0 ; c < grid[0].length; c++){

                if(grid[r][c] == '1'){
                    count ++;
                    sink(r,c);
                }
            }
        }
        return count;
    }

    public static void sink(int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';
        sink(row -1, col);
        sink(row + 1 , col);
        sink(row, col -1);
        sink(row, col + 1);
    }

    public static void main (String args[]){
        char grid[][] = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        int result = numsIslands(grid);
        System.out.println("Number of islands: " + result);

        char grid2[][] = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        int result2 = numsIslands(grid2);
        System.out.println("Number of islands: " + result2);        
    }
}
