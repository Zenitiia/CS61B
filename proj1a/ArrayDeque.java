public class ArrayDeque<T> {
    private int size;
    private int reservedSize;
    private int beginIdx;
    private int endIdx;
    private T[] elements;

//    ([)beginIdx, endIdx)

    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        this.size = 0;
        this.reservedSize = 8;
        this.beginIdx = 4;
        this.endIdx = 4;
        this.elements = (T[]) new Object[this.reservedSize];
    }

    @SuppressWarnings("unchecked")
    public ArrayDeque(int initSize) {
        if (initSize < 0) {
            System.out.println("init size < 0");
            initSize = 8;
        }
        this.size = initSize;
        this.reservedSize = initSize * 2;
        this.beginIdx = initSize;
        this.endIdx = initSize;
        this.elements = (T[]) new Object[this.reservedSize];
    }

    public void addFirst(T value) {
        if (this.beginIdx <= 0) {
            extend();
        }
        this.elements[this.beginIdx--] = value;
        this.size++;
    }

    public void addLast(T value) {
        if (this.endIdx >= this.reservedSize) {
            extend();
        }
        this.elements[this.endIdx++] = value;
        this.size++;
    }

    public void removeFirst() {
        if (this.size * 2 < this.reservedSize && this.reservedSize >= 16) {
            shrink();
        }
        this.elements[this.beginIdx++] = null;
        this.size--;
    }

    public void removeLast() {
        if (this.size * 2 < this.reservedSize && this.reservedSize >= 16) {
            shrink();
        }
        this.elements[this.endIdx--] = null;
        this.size--;
    }

    public T getItem(int idx) {
        return this.elements[beginIdx + idx];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @SuppressWarnings("unchecked")
    private void extend() {
        T[] newElements = (T[]) new Object[this.reservedSize * 2];
        System.arraycopy(this.elements, this.beginIdx + 1, newElements, (int) (this.reservedSize / 2), this.size);
        this.elements = newElements;
        this.beginIdx = (int) (this.reservedSize / 2);
        this.endIdx =  this.beginIdx + size + 1;
        this.reservedSize *= 2;
    }

    @SuppressWarnings("unchecked")
    private void shrink() {
        T[] newElements = (T[]) new Object[(int) (this.reservedSize / 2) + 1];
        System.arraycopy(this.elements, this.beginIdx + 1, newElements, 1, this.size);
        this.elements = newElements;
        this.beginIdx = 0;
        this.endIdx = this.size + 1;
        this.reservedSize /= 2;
    }

/*
    @SuppressWarnings("unchecked")
    private void checkBegin(int newBeginIdx) {
        int halfCapacity = (int) (0.5 * this.reservedSize);
        if (newBeginIdx < 0) {
            int addCapacity = halfCapacity;
            T[] newElements = (T[]) new Object[this.reservedSize + addCapacity];
            System.arraycopy(this.elements, this.beginIdx, newElements, addCapacity, this.endIdx - this.beginIdx);
            this.beginIdx = addCapacity;
            this.endIdx += addCapacity;
            this.reservedSize += addCapacity;
            this.elements = newElements;
        } if (newBeginIdx >= halfCapacity) {
            int removeCapacity = -halfCapacity;
            T[] newElements = (T[]) new Object[this.reservedSize - removeCapacity];
            System.arraycopy(this.elements, this.beginIdx, newElements, 0, this.endIdx - this.beginIdx);
            this.beginIdx = 0;
            this.endIdx -= removeCapacity;
            this.reservedSize -= removeCapacity;
            this.elements = newElements;
        }
    }
*/

    public int size() {
        return this.size;
    }

}
