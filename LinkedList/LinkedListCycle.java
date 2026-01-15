public class LinkedListCycle {
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    // static ListNode of(int ... values){
    //     if(values.length ==0){
    //         return null;
    //     }
    //     ListNode head = new ListNode(values[0]);
    //     ListNode current = head;
    //     for(int i =1; i< values.length ;i++){
    //         current.next = new ListNode(values[i]);
    //         current = current.next;
    //     }
    //     return head;
    // }

    static ListNode createCycle(int values[], int cyclePos){
        if(values.length ==0){
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleNode = (cyclePos == 0) ?  head: null;

        for(int i =1; i< values.length ; i++){
            current.next = new ListNode(values[i]);
            current = current.next;

            if(i == cyclePos){
                cycleNode = current;
            }
        }
            if (cyclePos >= 0) current.next = cycleNode;
        
            return head;
        
    }

    static void printList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.println(current.val + " ");
            current = current.next; 
        }               
        System.out.println();
    }

    static boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test 1: Has cycle (tail connects to index 1)
        ListNode list1 = createCycle(new int[]{3,2,0,-4}, 1);
        System.out.println("List [3,2,0,-4] cycle at 1: " + hasCycle(list1));
        
        // Test 2: No cycle (cyclePos = -1)
        ListNode list2 = createCycle(new int[]{1,2,3,4}, -1);
        System.out.println("List [1,2,3,4] no cycle: " + hasCycle(list2));
        
        // Test 3: Single node cycle
        ListNode list3 = createCycle(new int[]{1}, 0);
        System.out.println("List [1] cycle at 0: " + hasCycle(list3));
    }
}
