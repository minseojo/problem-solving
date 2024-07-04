class MyCircularDeque {

    static class DoublyLinkedList {
        DoublyLinkedList left;
        DoublyLinkedList right;
        int value;

        public DoublyLinkedList(int value) {
            this.value = value;
        }
    }

    private DoublyLinkedList head;
    private DoublyLinkedList tail;
    private int size;
    private int curSize;

    public MyCircularDeque(int k) {
        this.head = new DoublyLinkedList(0);
        this.tail = new DoublyLinkedList(0);
        this.head.right = tail;
        this.tail.left = head;
        this.size = k;
        this.curSize = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        DoublyLinkedList newNode = new DoublyLinkedList(value);
        newNode.left = head;
        newNode.right = head.right;
        head.right.left = newNode;
        head.right = newNode;
        curSize++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        DoublyLinkedList newNode = new DoublyLinkedList(value);
        newNode.left = tail.left;
        newNode.right = tail;
        tail.left.right = newNode;
        tail.left = newNode;
        curSize++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head.right = head.right.right;
        head.right.left = head;
        curSize--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail.left = tail.left.left;
        tail.left.right = tail;
        curSize--;
        return true;    
    }
    
    public int getFront() {
        if (isEmpty()) return -1;
        return head.right.value;
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        return tail.left.value;
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