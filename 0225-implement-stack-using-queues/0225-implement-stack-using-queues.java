class MyStack {
    
    Queue<Integer> inQueue;
    Queue<Integer> deQueue;

    public MyStack() {
        this.inQueue = new LinkedList<>();
        this.deQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        inQueue.add(x);
    }
    
    public int pop() {
        int front = -1;
        while (!inQueue.isEmpty()) {
            front = inQueue.poll();
            deQueue.add(front);
        }
        
        while (deQueue.size() > 1) {
            inQueue.add(deQueue.poll());
        }
        deQueue.poll();

        return front;
    }
    
    public int top() {
        int front = -1;
        while (!inQueue.isEmpty()) {
            front = inQueue.poll();
            deQueue.add(front);
        }
        
        while (!deQueue.isEmpty()) {
            inQueue.add(deQueue.poll());
        }

        return front;
    }
    
    public boolean empty() {
        if (inQueue.isEmpty() && deQueue.isEmpty()) return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */