import java.util.stream.IntStream;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        int[] numbers = IntStream.rangeClosed(left, right).toArray();

        for (int number : numbers) {
            answer = (IntStream.rangeClosed(1, number / 2).filter(i -> number % i == 0).count() + 1) % 2 == 0 ? answer + number : answer - number;
        }
        
        return answer;
    }
}