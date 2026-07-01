package CompanyPrep.Amazon;

import java.util.HashMap;
import java.util.Map;

import java.util.HashSet;
import java.util.Set;


public class MakingALargeIsland {
    public static void main(String args[]){
        int grid[][] = {{0,0,0,0,0,0,0},{1,1,1,1,1,0,0},{0,1,0,0,1,0,0},{1,0,1,0,1,0,0},{0,1,0,0,1,0,0},{0,1,0,0,0,0,0},{0,1,1,1,1,1,0}};
        int result= largestIsland(grid);
        System.out.println("The largest island is: " + result);
    }


    public static int largestIsland(int grid[][]){
        int n = grid.length;
        int islandId = 2;
        Map<Integer, Integer> islandSize = new HashMap<>();     

        for(int r = 0 ; r < n; r++){
            for(int c= 0; c< grid[0].length; c++){
                if(grid[r][c] == 1){
                    int size = dfs(grid, r, c, islandId);
                    islandSize.put(islandId, size);
                    islandId++;
                }
            }
        }

        if(islandSize.isEmpty()){
            return n*n;
        }

        int maxArea = 0;

        for(int size: islandSize.values()){
            maxArea = Math.max(maxArea, size);
        }

        int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int r = 0 ; r < n ; r++){
            for(int c = 0 ; c < n; c++){
                if(grid[r][c] != 0){
                    continue;
                }

                Set<Integer> seen  = new HashSet<>();
                for(int direction[] : directions){
                    int nr = r +direction[0];
                    int nc = c + direction[1];
                    if(nr >=0 && nr < n && nc >=0 && nc < n && grid[nr][nc] > 1){
                        seen.add(grid[nr][nc]);
                    }
                }

                int candidate = 1;
                for(int island : seen){
                    candidate += islandSize.get(island);
                }

                maxArea = Math.max(maxArea, candidate);
            }
        }
        return maxArea;
    }   

    private static int dfs(int grid[][], int r, int c, int islandId){
        int n = grid.length;
        if(r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1){
            return 0;
        }
        grid[r][c] = islandId;
        return 1 + dfs(grid, r+1 , c , islandId) + dfs(grid, r-1 , c , islandId) + dfs(grid, r, c+1 , islandId) + dfs(grid, r, c-1 , islandId);
    }
}
