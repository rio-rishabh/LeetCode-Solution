public class MergeTwoSortedList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next =null;
        }
    }

    static ListNode of(int ... values){
        if(values.length == 0){
            return null;
        }

        ListNode head  = new ListNode(values[0]);
        ListNode current = head;
        for(int i =1; i< values.length; i++){
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

    static ListNode mergeTwoSortedList(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            }
            else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = list1 != null ? list1 : list2;

        return dummy.next;
    }

    public static void main(String args[]){
        ListNode list1 = of(1,2,4);
        ListNode list2 = of(1,3,4);
        ListNode mergedList = mergeTwoSortedList(list1, list2);
        System.out.println("Merged list:");
        printList(mergedList);
    }
}
