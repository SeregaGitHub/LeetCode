package easy._203_remove_linked_list_elements;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode removeElementsLC(ListNode head, int val) {
        ListNode temp = new ListNode(0) , curr = temp;
        temp.next = head;
        while(curr.next != null ){
            if(curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        }
        return temp.next;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = null;
        ListNode bufferNode = head;

        // 3 val
        // 3 -> 4 -> 5 -> 6 -> 3 -> 3 -> 9

        while (bufferNode != null) {
            if (newHead == null) {
                if (bufferNode.val != val) {
                    newHead = bufferNode;
                } else {
                    bufferNode = bufferNode.next;
                }
            } else {
                if (bufferNode.next != null) {
                    if (bufferNode.next.val != val) {
                        bufferNode = bufferNode.next;
                    } else {
                        bufferNode.next = bufferNode.next.next;
                    }
                } else {
                    bufferNode = null;
                }
            }
        }

        return newHead;
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
