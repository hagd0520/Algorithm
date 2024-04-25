import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] words = new String[]{"aya", "ye", "woo", "ma"};
        
        for (String babble : babbling) {
            for (String word : words) {
                babble = babble.replaceFirst(word, " ");
            }
            
            if (babble.isBlank()) answer++;
        }
        
        return answer;
    }
}