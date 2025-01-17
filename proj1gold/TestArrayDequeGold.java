import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> test = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> std = new ArrayDequeSolution<>();
        StringBuffer log = new StringBuffer();
        for (int i = 0; i < 114; i++) {
            Integer x = StdRandom.uniform(1919);
            Integer type = StdRandom.uniform(4);
            Integer removedStd = 0;
            Integer removedTest = 0;
            if (std.isEmpty()) {
                type = StdRandom.uniform(2);
            }
            if (type == 0) {
                log.append("addFirst(");
                log.append(x);
                log.append(")\n");
                test.addFirst(x);
                std.addFirst(x);
            } else if (type == 1) {
                log.append("addLast(");
                log.append(x);
                log.append(")\n");
                test.addLast(x);
                std.addLast(x);
            } else if (type == 2) {
                log.append("removeFirst()\n");
                removedTest = test.removeFirst();
                removedStd = std.removeFirst();
            } else {
                log.append("removeLast()\n");
                removedTest = test.removeLast();
                removedStd = std.removeLast();
            }
            assertEquals(log.toString(), removedTest, removedStd);
        }
    }
}
