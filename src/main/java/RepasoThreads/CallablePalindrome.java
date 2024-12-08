package RepasoThreads;

import java.util.concurrent.Callable;

public class CallablePalindrome implements Callable <String> {
    String word;

    public CallablePalindrome(String w){
        this.word=w;
    }

    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder(word);
        String reversedWord = sb.reverse().toString();
        if(word.equals(reversedWord)){
            return word+" is palindrome";
        } else {
            return word+" is not a palindrome";
        }
    }
}
