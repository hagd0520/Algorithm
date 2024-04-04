import java.util.LinkedList;
import java.util.List;

class Solution {
    boolean[] visited;

    List<Integer> networks = new LinkedList<>();

    int network = 0;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];

        visit(computers);

        answer = network;

        return answer;
    }

    public void visit(int[][] computers) {
        for (int i = 0; i < computers.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            check(computers[i], i);

            while (!networks.isEmpty()) {
                int target = networks.remove(0);
                if (visited[target]) continue;
                visited[target] = true;
                check(computers[target], target);
            }

            network++;
        }
    }

    public void check(int[] computer, int i) {
        for (int j = 0; j < computer.length; j++) {
            if (i == j) continue;
            if ( computer[j] == 1 ) networks.add(j);
        }
    }
}