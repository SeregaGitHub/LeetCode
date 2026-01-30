package easy._83_remove_duplicates_from_sorted_list;

public class Solution {
    public static void main(String[] args) {
        ListNode listNode41 = new ListNode(4, null);
        ListNode listNode32 = new ListNode(3, listNode41);
        ListNode listNode31 = new ListNode(3, listNode32);
        ListNode listNode21 = new ListNode(2, listNode31);
        ListNode listNode12 = new ListNode(1, listNode21);
        ListNode listNode11 = new ListNode(1, listNode12);

        print(listNode11);
        ListNode listNode = deleteDuplicates(listNode11);

        System.out.println();

        assert listNode != null;
        print(listNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode listNode = head;

        while (true) {
            int currentVal = 0;
            try {
                currentVal = listNode.val;
            } catch (Exception e) {
                return null;
            }
            if (listNode.next != null) {
                if (currentVal != listNode.next.val) {
                    listNode = listNode.next;
                } else {
                    ListNode nextNode = listNode.next;
                    listNode.next = nextNode.next;
                    nextNode = null;
                }
            } else {
                break;
            }
        }
        return head;
    }

    public static void print(ListNode head) {
        int val = head.val;
        System.out.print(val + " ");

        if (head.next != null) {
            print(head.next);
        }
    }

    public static class ListNode {
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
