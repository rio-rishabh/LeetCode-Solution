package Graphs;

import java.util.List;
import java.util.ArrayList;

public class CourseSchedule {
    
    static int [] state;

    static List<List<Integer>> graph;
    public static boolean canFinish(int numCourses, int prerequisites[][]){
        if(numCourses <=0 || prerequisites == null || prerequisites.length == 0){
            return true;
        }

        state = new int[numCourses];
        graph = new ArrayList<>();

        for(int i = 0 ; i< numCourses ; i++){
            graph.add(new ArrayList<>());
        }

        for(int prerequisite[]: prerequisites){
            int course = prerequisite[0];
            int preCourse = prerequisite[1];

            graph.get(preCourse).add(course);
        }

        for(int course = 0 ; course < numCourses ; course ++){
            if(hasCycle(course)){
                return false;
            }
        }
        return true;
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
        return false;
    }

    public static void main(String args[]){
        int prerequisites[][] = {{1,0},{2,1},{3,2}};
        int numCourses = 4;
        boolean result = canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses: " + result);
    }
}
