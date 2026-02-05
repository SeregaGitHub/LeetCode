package easy._234_palindrome_linked_list;

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(ListNode head) {
        // 1 2 2 1
        // 1 2 3 2 1
        // 1 2 3 4 5 4 3 2 1
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        if (secondNode == null) return true;

        while (secondNode.next != null) {
            if (secondNode.next.next == null) {
                secondNode = secondNode.next;
            } else {
                firstNode = firstNode.next;
                secondNode = secondNode.next.next;
            }
        }

        secondNode = firstNode.next;

        ListNode prev = null;
        ListNode bufferNode = secondNode;
        while (bufferNode != null) {
            ListNode nextNode = bufferNode.next;
            bufferNode.next = prev;
            prev = bufferNode;
            bufferNode = nextNode;
        }

        while (head != firstNode.next) {
            if (head.val == prev.val) {
                head = head.next;
                prev = prev.next;
            } else {
                return false;
            }
        }

        return true;
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
