import java.util.Queue;
import java.util.ArrayDeque;
public class DesignHitCounter {
    public static void main(String args[]){
        DesignHitCounter hitCounter = new DesignHitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        System.out.println("The hit count at timestamp 4 is: " + hitCounter.getHits(4));
        hitCounter.hit(300);
        System.out.println("The hit count at timestamp 300 is: " + hitCounter.getHits(300));
        System.out.println("The hit count at timestamp 301 is: " + hitCounter.getHits(301));
    }

    private final int window = 300;
    private final Queue<Integer> queue;

    public DesignHitCounter(){
        this.queue = new ArrayDeque<>();
    }

    public void hit(int timestamp){
        queue.offer(timestamp);
    }

    public int getHits(int timestamp){
        while(!queue.isEmpty() && queue.peek() <= timestamp - window){
            queue.poll();
        }
        return queue.size();
    }
}
