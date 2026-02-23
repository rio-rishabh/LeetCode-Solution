package Heap;

import java.util.PriorityQueue;
public class MergeKSortedList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public static void printList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.println(current.val + " ");
            current = current.next;
        }
    System.out.println();
}
    public static ListNode mergeKList(ListNode lists[]){
        if(lists == null || lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue((a, b) -> a.val - b.val);

        for(ListNode list : lists){
            if(list != null){
                pq.offer(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            current.next = smallest;
            current = current.next;
            if(smallest.next != null){
                pq.offer(smallest.next);
            }
        }

        return dummy.next;
    }
    public static void main(String args[]){
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = {list1, list2, list3};
        ListNode mergedList = mergeKList(lists);
        System.out.println("Merged list:");
        printList(mergedList);
    }
}
