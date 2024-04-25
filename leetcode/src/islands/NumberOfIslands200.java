package islands;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands200 {
	
	private static final char LAND = '1';
    private static final int[][] DIRS = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == LAND) {
                    bfs(grid, i, j, visited);
                    num++;
                }
            }
        }
        return num;
    }

    private void bfs(char[][] grid, int x, int y, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { x, y });
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] loc = q.poll();
            for (int[] dir : DIRS) {
                int newX = loc[0] + dir[0];
                int newY = loc[1] + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]
                        && grid[newX][newY] == LAND) {
                    q.offer(new int[] { newX, newY });
                    visited[newX][newY] = true;
                }
            }
        }
    }
	
	

	public static void main(String[] args) {
		System.out.println(new NumberOfIslands200().numIslands(new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
	}

}
