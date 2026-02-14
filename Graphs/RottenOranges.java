package Graphs;
import java.util.Queue;
import java.util.LinkedList;

public class RottenOranges {
    public static int orangesRotting(int [][] grid){
        if(grid == null || grid.length ==0){
            return 0;
        }

        Queue<int []> queue = new LinkedList<>();
        int freshOranges = 0;

        for(int r = 0; r < grid.length ; r++){
            for(int c = 0 ; c < grid[0].length ; c++){
                if(grid[r][c] == 2){
                    queue.offer(new int [] {r, c});
                }
                if(grid[r][c] == 1){freshOranges++;}
            }
        }

        if(freshOranges == 0){
            return 0; // since no fresh oranges are present to be rotten.
        }

        int minutes = 0;
        int dirs[][] = {{0,1},{0,-1},{1,0}, {-1,0}};

        while (!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0 ; i< size; i++){
                int curr[] = queue.poll();

                for(int dir[]: dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        freshOranges --;
                    }
                }
            }
            minutes ++;
        }

        return freshOranges == 0 ? minutes -1 : -1;
    }

    public static void main(String args[]){
        int grid[][] = {{2,1,1},{1,1,0},{0,1,1}};
        int result = orangesRotting(grid);
        System.out.println("Time taken to rot all oranges: " + result);
    }
}
