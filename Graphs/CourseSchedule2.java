package Graphs;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class CourseSchedule2 {
    static int [] state;
    static List<List<Integer>> graph;
    static List<Integer> result;

    public static int[] findOrder(int numCourses, int prerequisities[][]){
        if(numCourses <= 0 || prerequisities == null){
            return new int[0];
        }

        state = new int[numCourses];
        graph = new ArrayList<>();
        result = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>());
        }

        for(int prerequisite[] : prerequisities){
            int course = prerequisite[0];
            int preCourse = prerequisite[1];

            graph.get(preCourse).add(course);
        }

        for(int course = 0 ; course < numCourses; course ++){
            if(hasCycle(course)){
                return new int[0];
            }
        }
        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static boolean hasCycle(int course){

        if(state[course] == 1){
            return true;
        }

        if(state[course] == 2){
            return false;
        }
        state[course] = 1;
        
        for(int nextCourse : graph.get(course)){
            if(hasCycle(nextCourse)){
                return true;
            }
        }
        state[course] = 2;
        result.add(course);
        return false;
    }

    public static void main(String args[]){
        int prerequisities[][] = {};
        int numCourses = 1;
        int result[] = findOrder(numCourses, prerequisities);
        System.out.println("Course order: " + Arrays.toString(result));
    }
}
