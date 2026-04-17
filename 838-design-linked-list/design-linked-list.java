class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node curr = getNode(index);
        return curr.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if (size == 0) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        Node curr = getNode(index);
        Node prevNode = curr.prev;
        Node node = new Node(val);

        prevNode.next = node;
        node.prev = prevNode;
        node.next = curr;
        curr.prev = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        if (size == 1) {
            head = tail = null;
        } else if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node curr = getNode(index);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }
        size--;
    }

    private Node getNode(int index) {
        Node curr;
        if (index < size / 2) {
            curr = head;
            for (int i = 0; i < index; i++) curr = curr.next;
        } else {
            curr = tail;
            for (int i = size - 1; i > index; i--) curr = curr.prev;
        }
        return curr;
    }
}