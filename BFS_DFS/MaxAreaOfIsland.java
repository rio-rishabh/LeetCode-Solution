package BFS_DFS;

public class MaxAreaOfIsland {

   static char grid[][];
    public static void main(String args[]){
        grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int result = maxAreaOfIsland(grid);
        System.out.println("Maximum area of island is: " + result);
    }

    public static int maxAreaOfIsland(char inputgrid[][]){
        if( inputgrid == null || inputgrid.length == 0){return 0;}

        int maxArea = 0;

        char grid [][] = inputgrid;

        for(int r= 0; r< grid.length ; r++){
            for(int c= 0; c< grid[0].length; c++){
                if(grid[r][c] == '1'){
                    maxArea = Math.max(maxArea, sink(r,c));
                }
            }
        }
        return maxArea;
    }

    public static int sink(int row , int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0'){return 0;}

        grid[row][col] = '0';
        int area = 1 + sink(row +1, col) +sink(row -1, col) + sink(row, col+1) + sink(row, col-1);
        return area;
    }
}
