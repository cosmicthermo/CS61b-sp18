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
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper(deque);
    }

    private boolean isPalindromeHelper(Deque<Character> deque) {
        if (deque.size() <= 1) {
            return true;
        }
        return deque.removeFirst().equals(deque.removeLast()) && isPalindromeHelper(deque);
    }

    // Task 4 OffByObe palindrome
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        return oboIsPalindromeHelper(deque, cc);
    }

    private boolean oboIsPalindromeHelper(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() <= 1) {
            return true;
        }
        return cc.equalChars(deque.removeFirst(), deque.removeLast()) && oboIsPalindromeHelper(deque, cc);
    }


}
