import org.junit.Test;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual
                    + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual
                    + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    public static void addIsEmptySizeTest() {
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");

        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);

    }

    public static void addRemoveTest() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);

    }

    @Test
    public void testSingle() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<Integer>();

        lld.addFirst(3);
        lld.addFirst(4);
        lld.printDeque();

        lld.removeFirst();
        lld.printDeque();

        lld.addLast(6);
        lld.printDeque();

        lld.removeLast();
        lld.printDeque();

        lld.removeFirst();
        lld.printDeque();

        lld.printDeque();

        lld.addLast(9);
        lld.removeFirst();
        lld.printDeque();
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
    }
}
