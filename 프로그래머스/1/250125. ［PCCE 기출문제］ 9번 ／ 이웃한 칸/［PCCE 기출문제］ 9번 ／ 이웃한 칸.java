class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String target = board[h][w];
        
        if (board.length - 1 > w && board[h][w + 1].equals(target)) answer++;
        if (w > 0 && board[h][w - 1].equals(target)) answer++;
        if (board.length - 1 > h && board[h + 1][w].equals(target)) answer++;
        if (h > 0 && board[h - 1][w].equals(target)) answer++;
        
        return answer;
    }
}