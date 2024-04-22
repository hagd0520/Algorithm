import java.util.*;

class Solution {
    List<int[]> queue = new LinkedList<>();
    int[][] targetBoard;
    boolean[][] visited;

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        List<Block> blockList = new ArrayList<>();

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = table[i][j] == 0 ? 1 : 0;
            }
        }

        targetBoard = table;

        this.visited = new boolean[table.length][table[0].length];

        for (int i = 0; i < targetBoard.length; i++) {
            for (int j = 0; j < targetBoard[0].length; j++) {
                if (visited[i][j]) continue;

                if (targetBoard[i][j] == 0) {
                    int[] position = check(i, j);

                    int[][] target = extractBlock(position);

                    for (int[] t : target) {
                        System.out.println(Arrays.toString(t));
                    }

                    int length = position[4];

                    blockList.add(new Block(length, target));
                }

                visited[i][j] = true;
            }
        }

        targetBoard = game_board;
        this.visited = new boolean[targetBoard.length][targetBoard[0].length];

        for (int i = 0; i < targetBoard.length; i++) {
            if (blockList.isEmpty()) break;
            for (int j = 0; j < targetBoard[0].length; j++) {
                if (visited[i][j]) continue;

                if (targetBoard[i][j] == 0) {
                    int[] position = check(i, j);

                    int[][] target = extractBlock(position);

                    int length = position[4];

                    for (int k = 0; k < blockList.size(); k++) {
                        Block block = blockList.get(k);
                        if (block.length == length && equal(target, block.shape)) {
                            answer += length;
                            blockList.remove(k);
                            break;
                        }
                    }
                }

                visited[i][j] = true;
            }
        }

        return answer;
    }

    public int[] check(int x, int y) {
        queue.add(new int[]{x, y});
        int[] position = new int[5];
        position[0] = x;
        position[1] = y;
        position[2] = x;
        position[3] = y;

        while (!queue.isEmpty()) {
            int[] xy = queue.remove(0);
            compose(xy[0], xy[1], position);
        }


        return position;
    }

    public void compose(int x, int y, int[] position) { // position = { startX, startY, endX, endY, length }
        if (visited[x][y]) return;
        visited[x][y] = true;
        targetBoard[x][y] = 2;
        position[4]++;

        if (x > 0 && targetBoard[x - 1][y] == 0) {
            if (position[0] >= x) position[0] = x - 1;
            queue.add(new int[]{x - 1, y});
        }
        if (targetBoard.length - 1 > x && targetBoard[x + 1][y] == 0) {
            if (position[2] <= x) position[2] = x + 1;
            queue.add(new int[]{x + 1, y});
        }
        if (y > 0 && targetBoard[x][y - 1] == 0) {
            if (position[1] >= y) position[1] = y - 1;
            queue.add(new int[]{x, y - 1});
        }
        if (targetBoard[0].length - 1 > y && targetBoard[x][y + 1] == 0) {
            if (position[3] <= y) position[3] = y + 1;
            queue.add(new int[]{x, y + 1});
        }
    }

    public int[][] extractBlock(int[] position) {
        int x = position[2] - position[0] + 1;
        int y = position[3] - position[1] + 1;

        int[][] target = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                target[i][j] = targetBoard[position[0] + i][position[1] + j] == 2 ? 1 : 0;
                targetBoard[position[0] + i][position[1] + j] = targetBoard[position[0] + i][position[1] + j] == 0 ? 0 : 1;
            }
        }

        return target;
    }

    public boolean equal(int[][] target, int[][] block) {
        if (Arrays.deepEquals(target, block)) return true;

        for (int i = 0; i < 3; i++) {
            block = turn(block);
            if (Arrays.deepEquals(target, block)) {
                return true;
            }
        }



        return false;
    }

    public int[][] turn(int[][] block) {
        int[][] turnedBlock = new int[block[0].length][block.length];

        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length; j++) {
                turnedBlock[j][block.length - i - 1] = block[i][j];
            }
        }

        return turnedBlock;
    }

}

class Block {
    public final int length;

    public final int[][] shape;

    public Block(int length, int[][] shape) {
        this.length = length;
        this.shape = shape;
    }
}