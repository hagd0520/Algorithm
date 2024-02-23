class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;

        for (int i = 0; i < section.length; i++) {
            for (int j = 0; j < section.length; j++) {
                if (section[j] - section[i] + 1 > m) {
                    answer++;
                    i = j - 1;
                    break;
                }
            };
        }

        return answer;
    }
}