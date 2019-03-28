package Page2;

/**
 *
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 Example:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 Given word = "ABCCED", return true.
 Given word = "SEE", return true.
 Given word = "ABCB", return false.
 * */
public class N79_WordSearch {

    public static void main(String[] args) {
        char[][] a = new char[][]{{'a', 'a'}};
        System.out.println(new N79_WordSearch().exist(a, "aaa"));
    }

    // 快速的解法
    public boolean exist_(char[][] board, String word) {

        if (board == null || word == null) {
            return true;
        }

        if (board.length == 0 && word.length() == 0) {
            return true;
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (existHelper(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }






    private boolean existHelper(char[][] board, String word, int start, int row, int col, boolean[][] visited) {
        if (start == word.length()) {
            return true;
        }

        //check if we're out of boundaries of the board
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }

        if (visited[row][col]) {
            return false;
        }

        if (board[row][col] != word.charAt(start)) {
            return false;
        }

        visited[row][col] = true;
        boolean result = existHelper(board, word, start + 1, row - 1, col, visited) ||
                existHelper(board, word, start + 1, row + 1, col, visited) ||
                existHelper(board, word, start + 1, row, col - 1, visited) ||
                existHelper(board, word, start + 1, row, col + 1, visited);
        visited[row][col] = false; //undo the visited cell so if it didn't work out we can try other paths

        return result;
    }

    public boolean exist(char[][] board, String word) {
        if (word == null || board == null) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 这一步 很慢
                boolean[][] isUsed = new boolean[board.length][board[0].length];
                if (helper(board, word, word.length(), i, j, isUsed)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean helper(char[][] board, String word, int num, int row, int col, boolean[][] isUsed) {
        if (num == 0) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        char cur = word.charAt(word.length() - num);
        if (board[row][col] == cur && !isUsed[row][col]) {
            isUsed[row][col] = true;
        } else {
            return false;
        }
        if (helper(board, word, num - 1, row - 1, col, isUsed) ||
                helper(board, word, num - 1, row + 1, col, isUsed) ||
                helper(board, word, num - 1, row, col + 1, isUsed) ||
                helper(board, word, num - 1, row, col - 1, isUsed)) {
            return true;
        } else {
            isUsed[row][col] = false;
            return false;
        }
    }
}
