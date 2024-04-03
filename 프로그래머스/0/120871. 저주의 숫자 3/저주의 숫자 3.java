class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 0;

        while (i < n) {
            if (i % 3 == 0 || (i + "").contains("3")) n++;
            i++;
        }

        answer = n - 1;

        return answer;
    }
}