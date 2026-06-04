import java.util.Queue;
import java.util.ArrayDeque;
public class MovingAverageFromDataStream {
    public static void main(String args[]){
        MovingAverageFromDataStream movingAverage = new MovingAverageFromDataStream(3);
        System.out.println("Moving average is: " + movingAverage.next(1));
        System.out.println("Moving average is: " + movingAverage.next(10));
        System.out.println("Moving average is: " + movingAverage.next(3));
        System.out.println("Moving average is: " + movingAverage.next(5));
        System.out.println("Moving average is: " + movingAverage.next(7));
    }

    private final int size;
    private final Queue<Integer> queue;
    private double sum;

    public MovingAverageFromDataStream(int size){
        this.size = size;
        this.queue = new ArrayDeque<>();
        this.sum = 0;
    }

    public double next(int val){
        if(queue.size() == size){
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}
