public class ArrayDeque<T> {
    private int size;
    private int reservedSize;
    private int beginIdx;
    private int endIdx;
    private T[] elements;

//    [beginIdx, endIdx)

    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        this.size = 0;
        this.reservedSize = 8;
        this.beginIdx = 0;
        this.endIdx = 0;
        this.elements = (T[]) new Object[this.reservedSize];
    }

/*    @SuppressWarnings("unchecked")
    public ArrayDeque(int initSize) {
        if (initSize < 0) {
            System.out.println("init size < 0");
            initSize = 8;
        }
        this.size = 0;
        this.reservedSize = Math.max(initSize, 8);
        this.beginIdx = 0;
        this.endIdx = 0;
        this.elements = (T[]) new Object[this.reservedSize];
    }*/

    public void addFirst(T value) {
        if (this.size == this.reservedSize) {
            extend();
        }
        this.beginIdx = (this.beginIdx - 1 + this.reservedSize) % this.reservedSize;
        this.elements[this.beginIdx] = value;
        this.size++;
    }

    public void addLast(T value) {
        if (this.size == this.reservedSize) {
            extend();
        }
        this.elements[this.endIdx] = value;
        this.endIdx = (this.endIdx + 1) % this.reservedSize;
        this.size++;
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Empty");
        }
        T res = this.elements[this.beginIdx];
        this.elements[this.beginIdx] = null;
        this.beginIdx = (this.beginIdx + 1) % this.reservedSize;
        this.size--;
        if (this.size * 2 + 1 < this.reservedSize && this.reservedSize >= 16) {
            shrink();
        }
        return res;
    }

    public T removeLast() {
        if (this.isEmpty()) {
            System.out.println("Empty");
        }
        this.endIdx = (this.endIdx - 1 + this.reservedSize) % this.reservedSize;
        T res = this.elements[this.endIdx];
        this.elements[this.endIdx] = null;
        this.size--;
        if (this.size * 2 + 1 < this.reservedSize && this.reservedSize >= 16) {
            shrink();
        }
        return res;
    }

    public T get(int idx) {
        return this.elements[(this.beginIdx + idx) % this.reservedSize];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @SuppressWarnings("unchecked")
    private void extend() {
        T[] newElements = (T[]) new Object[this.reservedSize * 2];
        for (int i = 0; i < this.size; i++) {
            newElements[i] = this.elements[(this.beginIdx + i) % this.reservedSize];
        }
        this.elements = newElements;
        this.beginIdx = 0;
        this.endIdx = this.size;
        this.reservedSize *= 2;
    }

    @SuppressWarnings("unchecked")
    private void shrink() {
        T[] newElements = (T[]) new Object[(int) (this.reservedSize / 2) + 1];
        for (int i = 0; i < this.size; i++) {
            newElements[i] = this.elements[(this.beginIdx + i) % this.reservedSize];
        }
        this.elements = newElements;
        this.beginIdx = 0;
        this.endIdx = this.size;
        this.reservedSize = (int) (this.reservedSize / 2) + 1;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        if (isEmpty()) {
            System.out.println("Empty!");
        }
        for (int i = this.beginIdx + 1; i < this.endIdx; i++) {
            System.out.print(this.elements[i] + " ");
        }
        System.out.print("\n");
    }
}
