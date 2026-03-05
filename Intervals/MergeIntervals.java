package Intervals;  

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MergeIntervals {
    public static int[][] merge(int intervals[][]){
        if(intervals == null || intervals.length == 0){
            return new int[][]{};
        }

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        int currentInterval[] = intervals[0];
        for(int i =1 ; i < intervals.length ;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start <= currentInterval[1]){
                currentInterval[1] = Math.max(currentInterval[1], end);
            }
            else{
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        result.add(currentInterval);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String args[]){
        int intervals[][] = {{1,3},{2,6},{8,10},{15,18}};
        int result[][] = merge(intervals);
        System.out.println("Merged intervals are: ");
        for(int i =0; i< result.length; i++){
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
    
}
