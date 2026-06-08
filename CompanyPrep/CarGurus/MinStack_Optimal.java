import java.util.Stack;
public class MinStack_Optimal {
    public static void main(String args[]){
        MinStack_Optimal minStack = new MinStack_Optimal();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        System.out.println("Minimum element is: " + minStack.getMin());
        minStack.pop();
        System.out.println("Minimum element is: " + minStack.getMin());
    }

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack_Optimal(){
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val){
        stack.push(val);
        if(minStack.isEmpty() || val < minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop(){
        if(stack.pop().equals(minStack.peek())){
            minStack.pop();
        }
    }
    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
}
