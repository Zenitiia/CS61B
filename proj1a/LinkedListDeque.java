public class LinkedListDeque<T> {

    private static class Node<T> {
        public T value;
        public Node<T> prev;
        public Node<T> next;
        public Node(T value, Node<T> prevNode, Node<T> nextNode) {
            this.value = value;
            this.prev = prevNode;
            this.next = nextNode;
        }
    }

    // head [ first ... last ] tail

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedListDeque() {
        this.head = new Node<T>(null, null, null);
        this.tail = new Node<T>(null, null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
    }

    public void addFirst(T value) {
        this.head.value = value;
        Node<T> tmpNode = new Node<T>(null, null, this.head);
        this.head.prev = tmpNode;
        this.head = tmpNode;
        this.size++;
    }

    public void addLast(T value) {
        this.tail.value = value;
        Node<T> tmpNode = new Node<T>(null, this.tail, null);
        this.tail.next = tmpNode;
        this.tail = tmpNode;
        this.size++;
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        Node<T> res = this.head.next;
        this.head.next = res.next;
        res.next.prev = this.head;
        size--;
        return res.value;
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        Node<T> res = this.tail.prev;
        this.tail.prev = res.prev;
        res.prev.next = this.tail;
        size--;
        return res.value;
    }

    public boolean isEmpty() {
        return this.head.next == this.tail || this.tail.prev == this.head;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        Node<T> p = this.head.next;
        while (index > 0 && p != this.tail) {
            p = p.next;
            index--;
        }
        if (index == 0) {
            return p.value;
        } else {
            System.out.println("Out of index!");
            return null;
        }
    }

    public T getRecursive(int index) {
        return getRecursive2(index, this.head.next);
    }

    private T getRecursive2(int index, Node<T> cur) {
        if (index == 0) {
            return cur.value;
        } else {
            return getRecursive2(index - 1, cur.next);
        }
    }

    public void printDeque() {
        if (this.isEmpty()) {
            System.out.println("Empty");
            return ;
        }
        Node<T> p = this.head.next;
        while (p.next != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.print("\n");
    }
}
