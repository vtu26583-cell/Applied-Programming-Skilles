class MyCircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.data = new int[k];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        
        if (isEmpty()) {
            head = 0;
        }
        
        // Circular increment: (index + 1) % capacity
        tail = (tail + 1) % capacity;
        data[tail] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        
        if (head == tail) {
            // Queue becomes empty after removing the last element
            head = -1;
            tail = -1;
        } else {
            // Move head forward circularly
            head = (head + 1) % capacity;
        }
        size--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return data[head];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return data[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}