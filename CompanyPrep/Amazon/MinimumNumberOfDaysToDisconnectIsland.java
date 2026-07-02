package CompanyPrep.Amazon;

public class MinimumNumberOfDaysToDisconnectIsland {
    public static void main(String args[]){
        int grid[][] = {{0,1,1,0},{1,1,1,0},{1,1,0,0},{0,0,0,0}};
        System.out.println(minDaysToDisconnectIsland(grid));
    }

    public static int minDaysToDisconnectIsland(int[][] grid){
        if(countIslands(grid) != 1){
            return 0;
        }
        
        for(int r = 0 ; r< grid.length; r++){
            for(int c = 0 ; c < grid[0].length ; c++){
                if(grid[r][c] == 0){
                    continue;
                }
                grid[r][c] = 0;
                if(countIslands(grid) != 1){
                    grid[r][c] = 1;
                    return 1;
                }
                grid[r][c] = 1;
            }
        }

        for(int r1 = 0 ; r1 < grid.length; r1++){
            for(int c1 = 0 ; c1 < grid[0].length; c1++){
                if(grid[r1][c1] == 0){
                    continue;
                }
                grid[r1][c1] = 0;

                for(int r2 = 0 ; r2 < grid.length ; r2++){
                    for(int c2 = 0 ; c2 < grid[0].length; c2++){
                        if(grid[r2][c2] == 0){
                            continue;
                        }
                        grid[r2][c2] = 0;
                        if(countIslands(grid ) != 1){
                            grid[r2][c2] = 1;
                            grid[r1][c1] = 1;
                            return 2;
                        }
                        grid[r2][c2] =1 ;
                    }
                }
                grid[r1][c1] = 1;
            }
        }
        return 2;
    }

    public static int countIslands(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] copy = new int[rows][cols];
        for(int r = 0 ; r < rows; r++){
            System.arraycopy(grid[r], 0, copy[r], 0, cols);
        }
        int count = 0;
        for(int r = 0 ; r < rows; r++){
            for(int c = 0 ; c < cols; c++){
                if(copy[r][c] == 1){
                    count++;
                    dfs(copy, r, c);
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >=grid[0].length || grid[r][c] == 0){
            return;
        }
        grid[r][c] = 0;
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}
