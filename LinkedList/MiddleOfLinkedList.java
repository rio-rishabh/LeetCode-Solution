public class MiddleOfLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    static ListNode of(int ... values){
        if(values.length == 0){
            return null ;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current  = head;
        for(int i =1; i< values.length ; i++){
            current.next = new ListNode(values[i]);
            current = current.next;
        }
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

    static ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main (String args[]){
        ListNode head = of(1,2,3,4,5,6,7);
        System.out.println("Original list:");
        printList(head);
        ListNode middle = middleNode(head);
        System.out.println("Middle node value: " + middle.val);
    }
}
