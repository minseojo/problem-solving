class MyCircularQueue {

    int[] queue;
    int front;
    int rear;
    int size;

    public MyCircularQueue(int k) {
        this.queue = new int[k];  
        this.front = 0;
        this.rear = 0;
        this.size = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        queue[rear % size] = value;
        rear++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        front++;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return queue[front % size];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return queue[(rear - 1) % size];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
        return rear - front >= size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */