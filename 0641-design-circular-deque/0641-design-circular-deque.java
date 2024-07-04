class MyCircularDeque {

    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int curSize;

// 0 1  2 3
//   홀 짝

// 2 3.  1
//  rear front

    public MyCircularDeque(int k) {
        this.front = (k - 1) / 2;
        this.rear = (k - 1) / 2 + 1;
        this.size = k;
        this.deque = new int[k];
        this.curSize = 0;
    }
    
    public boolean insertFront(int value) {
        if (this.isFull()) return false;
        deque[front % size] = value;
        front--;
        if (front < 0) front = size - 1;
        curSize++;
        return true;

    }
    
    public boolean insertLast(int value) {
        if (this.isFull()) return false;
        deque[rear % size] = value;
        rear++;
        if (rear >= size) rear = 0;
        curSize++;
        return true;
    }
    
    public boolean deleteFront() {
        if (this.isEmpty()) return false;
        front++;
        if (front >= size) front = 0;
        curSize--;
        return true;
    }
    
    public boolean deleteLast() {
        if (this.isEmpty()) return false;
        rear--;
        if (rear < 0) rear = size - 1;
        curSize--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) return -1;
        if (front + 1 >= size) return deque[(front + 1) % size];
        return deque[(front + 1) % size];
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        if (rear - 1 < 0) return deque[(size - 1) % size];
        return deque[(rear - 1) % size];
    }
    
    public boolean isEmpty() {
        return curSize == 0;
    }
    
    public boolean isFull() {
        return curSize == size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */