import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (Comparator.comparingInt(a -> a[0])));

        int high = 0;
        int low = 0;

        for (int[] target : targets) {
            if (high <= target[0]) {
                answer++;
                high = target[1];
                continue;
            }
            
            if (high > target[1]) {
                high = target[1];
            }
        }
        
        return answer;
    }
}