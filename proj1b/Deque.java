public interface Deque<T> {
    void addLast(T value);
    void addFirst(T value);
    boolean isEmpty();
    T removeFirst();
    T removeLast();
    void printDeque();
    int size();
    T get(int idx);
}
