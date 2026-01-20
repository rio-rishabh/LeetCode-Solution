public class PalindromeLinkedList {
    static class ListNode{
        int val;
        ListNode next;
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

        for(int i =1 ; i< values.length; i++){
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
        System.out.println();
        }
    }

    static boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow);


        ListNode p1 = head;
        ListNode p2 = secondHalf;

        while(p2 != null){
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }


    static ListNode reverse(ListNode head){
        ListNode prev = null, current = head;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


    public static void main(String args[]){
        ListNode head = of(1,2,3,4,3,2,1);
        System.out.println("Original list:");
        printList(head);
        boolean isPalindrome = isPalindrome(head);
        System.out.println("Is palindrome: " + isPalindrome);
    }
}
