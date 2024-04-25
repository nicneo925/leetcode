package snap;

import java.util.ArrayDeque;
import java.util.Queue;

public class WordSearch79 {

	private final static int[][] DIRS = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean exist = dfs(board, i, j, word, 0, visited);
                if (exist) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index + 1 == word.length()) {
            return true;
        }
        int m = board.length, n = board[0].length;
        visited[i][j] = true;
        for (int[] dir : DIRS) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                if (dfs(board, newX, newY, word, index + 1, visited)) {
                    return true;
                }

            }
        }
        visited[i][j] = false;
        return false;
    }

	public static void main(String[] args) {
		System.out.println(new WordSearch79().exist(
				new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCB"));

	}

}
