class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int index = 0;
        int answerIndex = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        while (end != sequence.length || index > k) {
            if (index <= k) {
                index += sequence[end];
                end++;
            }
            if (index > k) {
                index -= sequence[start];
                start++;
            }
            if(k == index && answerIndex > end - start - 1) {
                answerIndex = end - start - 1;
                answer[0] = start;
                answer[1] = end -1;
            }
        }

        return answer;
    }
}