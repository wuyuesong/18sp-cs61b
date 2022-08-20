import java.util.Calendar;

public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> res = new LinkedListDeque<>();
        for(int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        Palindrome palindrome = new Palindrome();
        return isPalindrome(palindrome.wordToDeque(word));
    }

    public boolean isPalindrome(Deque<Character> word) {
        if(word.size() == 1 || word.isEmpty()) {
            return true;
        }
        Character a = word.removeFirst();
        Character b = word.removeLast();
        if(a.equals(b)) {
            return isPalindrome(word);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Palindrome palindrome = new Palindrome();
        return isPalindrome(palindrome.wordToDeque(word), cc);
    }

    public boolean isPalindrome(Deque<Character> word, CharacterComparator cc) {
        if(word.size() == 1 || word.isEmpty()) {
            return true;
        }
        Character a = word.removeFirst();
        Character b = word.removeLast();
        if(cc.equalChars(a, b)) {
            return isPalindrome(word);
        }
        return false;
    }
}
