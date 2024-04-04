import java.util.LinkedList;
import java.util.List;

class Solution {
    List<Integer> queue = new LinkedList<>();
    int[] visited;
    String[] words;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new int[words.length];
        this.words = words;

        check(begin, -1);

        while (!queue.isEmpty()) {
            int curPoint = queue.remove(0);
            if (words[curPoint].equals(target)) {
                answer = visited[curPoint];
                break;
            }
            check(curPoint);
        }

        System.out.println(answer);

        return answer;
    }

    public void check(String begin, int curPoint) {
        for (int i = 0; i < words.length; i++) {
            if (visited[i] != 0) continue;
            if (match(begin, words[i])) {
                queue.add(i);
                if (curPoint == -1) {
                    visited[i]++;
                    continue;
                }
                visited[i] = visited[curPoint] + 1;
            }
        }
    }

    public void check(int curPoint) {
        check(words[curPoint], curPoint);
    }

    public boolean match(String x, String y) {
        String[] xs = x.split("");
        String[] ys = y.split("");
        int count = 0;
        for (int i = 0; i < xs.length; i++) {
            if (xs[i].equals(ys[i])) count++;
        }

        return count == xs.length - 1;
    }
}