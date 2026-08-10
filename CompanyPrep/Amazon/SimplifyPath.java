package CompanyPrep.Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public static void main(String args[]){
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
        System.out.println(simplifyPath("/a/b/c/d/e/f/g/h/i/j/k/l/m/n/o/p/q/r/s/t/u/v/w/x/y/z/"));
        System.out.println(simplifyPath("/a/b/c/d/e/f/g/h/i/j/k/l/m/n/o/p/q/r/s/t/u/v/w/x/y/z/"));
    }

    public static String simplifyPath(String path){
        Deque<String> stack = new ArrayDeque<>();

        for(String part : path.split("/")){
            if(part.isEmpty() || part.equals(".")){continue;}
            else if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pollLast();
                }
            }
            else{
                stack.offerLast(part);
            }
        }
        if(stack.isEmpty()){return "/";}

        StringBuilder result = new StringBuilder();

        for(String dir: stack){
            result.append("/").append(dir);
        }

        return result.toString();
    }
}
