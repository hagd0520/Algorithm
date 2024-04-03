import java.util.LinkedList;
import java.util.Queue;

class Solution {
    Queue<int[]> workToDo = new LinkedList<>();

    public int solution(int[][] maps) {
        int x = 0;
        int y = 0;

        int answer = -1;

        go(x, y, maps);

        while (!workToDo.isEmpty()) {
            int[] xy = workToDo.poll();
            x = xy[0];
            y = xy[1];
            if (x == maps.length - 1 && y == maps[0].length - 1) {
                answer = maps[x][y];
                break;
            }
            go(x, y, maps);
        }

        System.out.println(answer);
        return answer;
    }

    public void go(int x, int y, int[][] maps) {
        if (y < maps[0].length - 1 && maps[x][y + 1] == 1) {
            workToDo.add(new int[]{x, y + 1});
            maps[x][y + 1] = maps[x][y] + 1;
        }
        if (y > 0 && maps[x][y - 1] == 1) {
            workToDo.add(new int[]{x, y - 1});
            maps[x][y - 1] = maps[x][y] + 1;
        }
        if (x > 0 && maps[x - 1][y] == 1) {
            workToDo.add(new int[]{x - 1, y});
            maps[x - 1][y] = maps[x][y] + 1;
        }
        if (x < maps.length - 1 && maps[x + 1][y] == 1) {
            workToDo.add(new int[]{x + 1, y});
            maps[x + 1][y] = maps[x][y] + 1;
        }
    }
}