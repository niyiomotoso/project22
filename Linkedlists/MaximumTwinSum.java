package Linkedlists;

public class MaximumTwinSum {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next  = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        MaximumTwinSum sw = new MaximumTwinSum();
        System.out.println(sw.sum(head));
    }

    public int sum(ListNode head) {
        LinkedList li = new LinkedList();
        int listSize = li.listSize(head);
        li.printList(head);
        //ListNode firstPart = li.subList(a, 0, listSize/2 - 1);
        ListNode secondPart = li.subList(head, listSize/2, listSize -1);
        ListNode reversedSecondPart = li.reverseList(secondPart);

        ListNode reversedHead = reversedSecondPart;

        int max = 0;
        while(reversedHead != null) {
            int summ = reversedHead.val + head.val;
            max = Math.max(max, summ);
            reversedHead = reversedHead.next;
            head = head.next;
        }

        return max;
    }

}
