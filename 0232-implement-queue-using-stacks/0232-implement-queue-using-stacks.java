class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> deStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.deStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.add(x);
    }
    
    public int pop() {
        while (!inStack.isEmpty()) {
            deStack.add(inStack.pop());
        }

        int top = deStack.pop();

        while( (!deStack.isEmpty())) {
            inStack.add(deStack.pop());
        }

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
        if (inStack.isEmpty() && deStack.isEmpty()) return true;
        return false;
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