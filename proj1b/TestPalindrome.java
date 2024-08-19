import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void isPalindrome() {
        String testWord1 = "";
        assertTrue(palindrome.isPalindrome(testWord1));
        String testWord2 = "asdsa";
        assertTrue(palindrome.isPalindrome(testWord2));
        String testWord3 = "aabbccdd";
        assertFalse(palindrome.isPalindrome(testWord3));
    }
}
