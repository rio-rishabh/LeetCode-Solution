package CompanyPrep.Amazon;

public class NumberOfIslands {
    public static void main(String args[]){
        char grid[][] = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int result = numsIslands(grid);
        System.out.println("Number of islands: " + result);
    }

    public static int numsIslands(char inputgrid[][]){
        if(inputgrid == null || inputgrid.length == 0){return 0;}

        int count = 0;
        char grid [][] = inputgrid;

        for(int r = 0 ; r < grid.length; r++){
            for(int c = 0 ; c < grid[0].length; c++){
                if(grid[r][c] == '1'){
                    count ++;
                    sink(grid,r,c);
                }
            }
        }
        return count;
    }

    public static void sink(char grid[][], int row, int col){
        if(row < 0 || row >=grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0'){return;}
        grid[row][col] = '0';
        sink(grid, row + 1, col);
        sink(grid, row - 1, col);
        sink(grid, row, col + 1);
        sink(grid, row, col - 1);
    }
}
