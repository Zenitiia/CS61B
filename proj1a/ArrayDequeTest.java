import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void testIsEmpty() {
        ArrayDeque<String> arr = new ArrayDeque<String>();
        assertEquals(true, arr.isEmpty());

        arr.addLast("111");
        arr.addLast("111");
        arr.removeLast();
        arr.removeLast();
        assertEquals(true, arr.isEmpty());
        assertEquals(0, arr.size());
    }

    @Test
    public void testExtend() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        for (int i = 1; i <= 16; i++) {
            arr.addFirst(11);
            System.out.println("i = " + i);
            arr.printDeque();
            assertEquals(i, arr.size());
        }

        for (int i = 15; i >= 0; i--) {
            arr.removeLast();
            assertEquals(i, arr.size());
        }
    }

    @Test
    public void testRemove() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        arr.addFirst(1);
        arr.addFirst(2);
        System.out.println(arr.removeLast());
        arr.addFirst(3);
        System.out.println(arr.removeLast());
    }

}
