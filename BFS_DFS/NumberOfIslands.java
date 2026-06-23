package BFS_DFS;

public class NumberOfIslands {
    static char grid[][] = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

    public static void main(String args[]){
        int result = numsIslands(grid);
        System.out.println("Number of islands: " + result);
    }

    public static int numsIslands(char inputgrid[][]){
        if(grid  == null || grid.length == 0){return 0;}

        int count = 0;
        char grid [][] = inputgrid;

        for(int r = 0 ; r < grid.length; r++){
            for(int c= 0 ; c < grid[0].length; c++){
                if(grid[r][c] == '1'){
                    count ++;
                    sink(r,c);
                }
            }
        }
        return count;
    }

    public static void sink(int row , int col){
        if(row <  0 || col < 0 || row >=grid.length || col >=grid[0].length || grid[row][col] == '0'){return;}
        grid[row][col] = '0';
        sink(row + 1, col);
        sink(row - 1, col);
        sink(row, col + 1);
        sink(row, col - 1);
    }
}



