import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        int answer = IntStream.rangeClosed(1, n / 2).filter(i -> n % i == 0).reduce(0, Integer::sum) + n;
        
        return answer;
    }
}