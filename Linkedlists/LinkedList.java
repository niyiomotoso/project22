package Linkedlists;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }
}
public class LinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next  = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // new LinkedList().printList(head);
        // new LinkedList().printList(new LinkedList().reverseList(head));
        ListNode curr = new ListNode();
         curr.next = head;
        while (head != null) {
            head = head.next;
        }

        new LinkedList().printList(curr);
    }

    public void printList(ListNode head) {
        System.out.println("");
        while (head != null) {
            System.out.print(" "+head.val);
            head = head.next;
        }
        System.out.println("");
    }

    public int listSize(ListNode head) {
        int count = 0;
        while (head !=null) {
            head = head.next;
            count++;
        }

        return count;
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        //1 -> 2 -> 3 -> 4
        // 4->3->2->1
        while (curr != null) {
            ListNode nextNode = curr.next;
            // curr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public ListNode subList(ListNode head, int from, int to) {
        int count = 0;
        ListNode curr = head;
        ListNode prev = null;
        ListNode subList = new ListNode();
        ListNode dummyHead = subList;
        while (curr != null) {
            ListNode nextNode = curr.next;

            if (count >= from && count <= to) {
                curr.next = prev;
               subList.next = new ListNode(curr.val);
               subList = subList.next;
         }

            curr = nextNode;
            count++;
        }

       return dummyHead.next;
    }
}
