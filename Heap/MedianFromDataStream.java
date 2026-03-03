package Heap;

import java.util.PriorityQueue;
public class MedianFromDataStream {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

    public void addNum(int num){
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num);
        }
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }
        else if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian(){
        if(maxHeap.size() == minHeap.size()){
            return ((double) (maxHeap.peek() + minHeap.peek()) / 2);
        }
        else{
            return maxHeap.peek();
        }
    }

    public static void main(String args[]){
        MedianFromDataStream medianFromDataStream = new MedianFromDataStream();
        medianFromDataStream.addNum(1);
        medianFromDataStream.addNum(2);
        medianFromDataStream.addNum(3);
        medianFromDataStream.addNum(4);
        System.out.println("Median is: " + medianFromDataStream.findMedian());
        medianFromDataStream.addNum(5);
        System.out.println("Median is: " + medianFromDataStream.findMedian());
        medianFromDataStream.addNum(6);
        System.out.println("Median is: " + medianFromDataStream.findMedian());
        medianFromDataStream.addNum(7);
        System.out.println("Median is: " + medianFromDataStream.findMedian());
        medianFromDataStream.addNum(8);
        System.out.println("Median is: " + medianFromDataStream.findMedian());
    }
}
