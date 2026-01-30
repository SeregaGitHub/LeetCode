package easy._21_merge_two_sorted_lists;

public class Solution {
    public static void main(String[] args) {
        ListNode listNode14 = new ListNode(4, null);
        ListNode listNode12 = new ListNode(2, listNode14);
        ListNode list1 = new ListNode(1, listNode12);

        ListNode listNode24 = new ListNode(4, null);
        ListNode listNode23 = new ListNode(3, listNode24);
        ListNode list2 = new ListNode(1, listNode23);

        ListNode result = mergeTwoLists(list1, list2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
//0 ->
//0 ->
    // 1 -> 2 -> 4
    // 1 -> 3 -> 4

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preFirstNode = new ListNode();
        ListNode bufferNode = preFirstNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                bufferNode.next = list1;
                list1 = list1.next;
            } else {
                bufferNode.next = list2;
                list2 = list2.next;
            }
            bufferNode = bufferNode.next;
        }
        bufferNode.next = list1 == null ? list2 : list1;

        return preFirstNode.next;
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
