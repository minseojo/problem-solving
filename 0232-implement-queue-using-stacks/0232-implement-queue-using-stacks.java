class MyQueue {

    Deque<Integer> inStack = new ArrayDeque<>();
    Deque<Integer> deStack = new ArrayDeque<>();

    public void push(int x) {
        inStack.addLast(x);
    }
    
    public int pop() {
        int top = peek();
        deStack.pollLast();
        return top;
    }
    
    public int peek() {
        while (!inStack.isEmpty()) {
            deStack.add(inStack.pop());
        }

        int top = deStack.peek();
        
        while( (!deStack.isEmpty())) {
            inStack.add(deStack.pop());
        }

        return top;
    }
    
    public boolean empty() {
        return inStack.isEmpty() && deStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */