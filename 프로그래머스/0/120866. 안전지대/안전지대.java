class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] index = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    if (i > 0) {
                        if (j > 0) index[i - 1][j - 1] = 1;
                        index[i - 1][j] = 1;
                        if (j < board[j].length - 1) index[i - 1][j + 1] = 1;
                    }

                    if (j > 0) index[i][j - 1] = 1;
                    index[i][j] = 1;
                    if (j < board[j].length - 1) index[i][j + 1] = 1;

                    if (i < board.length - 1) {
                        if (j > 0) index[i + 1][j - 1] = 1;
                        index[i + 1][j] = 1;
                        if (j < board[j].length - 1) index[i + 1][j + 1] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < index.length; i++) {
            for (int j = 0; j < index[i].length; j++) {
                if (index[i][j] == 0) answer++;
            }

        }

        System.out.println(answer);
        return answer;
    }
}