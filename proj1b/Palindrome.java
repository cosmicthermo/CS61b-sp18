/**
 * A class for palindrome operations
 */
public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i += 1) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }


    public boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper(deque);
    }

    private boolean isPalindromeHelper(Deque<Character> deque) {
        if (deque.size() <= 1) {
            return true;
        }
        return deque.removeFirst().equals(deque.removeLast()) && isPalindromeHelper(deque);
    }


}
