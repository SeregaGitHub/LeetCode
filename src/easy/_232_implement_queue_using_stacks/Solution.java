package easy._232_implement_queue_using_stacks;

public class Solution {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);

        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
