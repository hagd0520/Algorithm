import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> giveIndex = new HashMap<>();
        Map<Integer, Integer> getIndex = new HashMap<>();

        int[] answer = new int[4];

        int maxCountOfPeak = 0;

        for (int[] edgesArray : edges) { // 준 수와 받은 수, 최대 정점 수 인댁싱
            if (edgesArray[0] > maxCountOfPeak) maxCountOfPeak = edgesArray[0];
            if (edgesArray[1] > maxCountOfPeak) maxCountOfPeak = edgesArray[1];

            giveIndex.put(edgesArray[0], giveIndex.getOrDefault(edgesArray[0], 0) + 1);

            getIndex.put(edgesArray[1], getIndex.getOrDefault(edgesArray[1], 0) + 1);
        }


        for (int i = 1; i <= maxCountOfPeak + 1; i++) { // 다른 그래프들과 무관한 정점
            if (!getIndex.containsKey(i) && giveIndex.get(i) > 1) {
                answer[0] = i;
                break;
            }
        }

        int countOfGraph = giveIndex.get(answer[0]);

        int stickGraph = 0;

        for (int i = 1; i <= maxCountOfPeak; i++) { // 막대 모양 그래프 인댁싱
            if (!giveIndex.containsKey(i)) stickGraph++;
        }

        int eightGraph = 0;

        for (int i = 1; i <= maxCountOfPeak; i++) {
            if (getIndex.getOrDefault(i, 0) >= 2 && giveIndex.getOrDefault(i, 0) >= 2) eightGraph++;
        }

        int donutGraph = countOfGraph - stickGraph - eightGraph;

        answer[1] = donutGraph;
        answer[2] = stickGraph;
        answer[3] = eightGraph;

        // 준 횟수가 0인 애의 수 = 막대 그래프의 수
        // 받은 횟수와 준 횟수 모두 2 이상인 정점의 수 = 8자 그래프의 수
        // 총 그래프 수 - (막대 그래프 + 8자 그래프) = 도넛 모양 그래프

        return answer;
    }
}