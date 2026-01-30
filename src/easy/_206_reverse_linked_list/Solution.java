package easy._206_reverse_linked_list;

public class Solution {
    public static void main(String[] args) {

        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode currentNode = listNode1;
        do {
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.next;
        } while (currentNode != null);

        System.out.println("\n========================================");

        ListNode currentNode2 = reverseList(listNode1);
        do {
            System.out.print(currentNode2.val + " ");
            currentNode2 = currentNode2.next;
        } while (currentNode2 != null);
    }

    public static ListNode reverseList(ListNode head) {
           // 1 -> 2 -> 3 -> 4 -> 5
    // pr  // b   next

        ListNode prev = null;
        ListNode buffer = head;

        while (buffer != null) {
            ListNode bufferNext = buffer.next;
            buffer.next = prev;
            prev = buffer;
            buffer = bufferNext;
        }
        return prev;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
