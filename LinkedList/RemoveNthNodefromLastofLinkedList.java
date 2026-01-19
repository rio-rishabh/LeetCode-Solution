public class RemoveNthNodefromLastofLinkedList {
    static class ListNode{
        int val;
        ListNode next ;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    static ListNode of(int ... values){
        if(values.length == 0){
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for(int i = 1; i< values.length; i++){
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

    static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for(int i= 0 ; i< n; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String args[]){
        ListNode head = of(1,2,3,4,5);
        System.out.println("Original list:");
        printList(head);
        int n = 4;
        ListNode newHead = removeNthFromEnd(head, n);
        System.out.println("List after removing " + n + "th node from last:");
        printList(newHead);
    }
}
