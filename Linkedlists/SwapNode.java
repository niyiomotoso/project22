package Linkedlists;


public class SwapNode {
    // COULD NOT SOLVE THIS
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next  = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

       SwapNode sw = new SwapNode();
       new LinkedList().printList(sw.swap(head));
    }

    public ListNode swap(ListNode head) {
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        // 2 -> 1   ->   4 -> 3   ->   6 -> 5
        ListNode curr = head;
        ListNode prev = null;
        int separator = 1;
        while (curr != null) {
            ListNode nextNode = curr.next;

            if (separator%2 == 0) {
                curr.next = prev;
                prev = curr;
            }

            curr = nextNode;
            separator ++;
        }

        return prev;
    }
}
