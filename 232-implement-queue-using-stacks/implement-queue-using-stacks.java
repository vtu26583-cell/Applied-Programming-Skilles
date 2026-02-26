import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1; // Input stack
    private Stack<Integer> s2; // Output stack

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
        public void push(int x) {
        s1.push(x);
    }
    public int pop() {
        if (s2.isEmpty()) {
            moveS1toS2();
        }
        return s2.pop();
    }
        public int peek() {
        if (s2.isEmpty()) {
            moveS1toS2();
        }
        return s2.peek();
    }
        public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    private void moveS1toS2() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
}