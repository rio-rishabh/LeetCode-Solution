package BFS_DFS;

import java.util.Queue;
import java.util.LinkedList;

public class RottingOranges {
    static int grid[][];

    public static void main(String args[]){
        grid = new int [][]{{2,1,1},{1,1,0},{0,1,1}};
        int result = orangesRotting(grid);
        System.out.println("Time taken to rot all oranges: " + result + " minutes");
    }

    public static int orangesRotting(int inputgrid[][]){
        if(inputgrid == null || inputgrid.length == 0){return 0;}
        int grid[][] = inputgrid;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int r = 0 ; r< grid.length ; r++){
            for(int c= 0 ; c< grid[0].length ; c++){
                if(grid[r][c] == 2){
                    queue.offer(new int[] {r,c});
                }
                if(grid[r][c] == 1){fresh++;}
            }
        }

        if(fresh ==0){return 0;}
        int minutes = 0;

        int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0 ; i < size; i++){
                int curr[] = queue.poll();
                for(int dir[] : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >=0 && nr < grid.length && nc >=0 && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        queue.offer(new int[] {nr,nc});
                        fresh --;
                    }
                }
            }
            minutes++;
        }
        return fresh ==0 ? minutes - 1 : -1;
    }
}



