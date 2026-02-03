package easy._232_implement_queue_using_stacks;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> mainStack = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        Stack<Integer> bufferStack = new Stack<>();

        while (!mainStack.isEmpty()) {
            bufferStack.push(mainStack.pop());
        }

        mainStack.push(x);

        while (!bufferStack.isEmpty()) {
            mainStack.push(bufferStack.pop());
        }
    }

    public int pop() {
        return mainStack.pop();
    }

    public int peek() {
        return mainStack.peek();
    }

    public boolean empty() {
        return mainStack.isEmpty();
    }
}
