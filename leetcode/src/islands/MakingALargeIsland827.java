package islands;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MakingALargeIsland827 {

	private static final int[][] DIRS = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    private static final int LAND = 1;

    public int largestIsland(int[][] grid) {
        int size = grid.length;
        int max = 0;
        // use label to mark if a node is visited or not
        int[][] label = new int[size][size];
        Map<Integer, Integer> labelCount = new HashMap<>();
        int labelIndex = 1;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (label[i][j] == 0 && grid[i][j] == LAND) {
                    int count = bfs(grid, i, j, label, labelIndex, label);
                    max = Math.max(max, count);
                    labelCount.put(labelIndex, count);
                    labelIndex++;
                }

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 0) {
                    int sum = 1;
                    Set<Integer> addedLabel = new HashSet<>();
                    // connect components
                    for (int[] dir : DIRS) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < size && y >= 0 && y < size && grid[x][y] == LAND
                                && !addedLabel.contains(label[x][y])) {
                            sum += labelCount.get(label[x][y]);
                            addedLabel.add(label[x][y]);
                        }
                    }
                    max = Math.max(max, sum);
                }

            }
        return max;
    }

    // Mark all connected components from (x,y) with labelIndex and returns the
    // total # of connected LANDS
    public int bfs(int[][] grid, int x, int y, int[][] label, int labelIndex, int[][] visited) {
        int size = grid.length;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { x, y });
        visited[x][y] = labelIndex;
        int count = 0;
        while (!q.isEmpty()) {
            int[] loc = q.poll();
            // the total number enqueued is the total island size;
            count++;
            for (int[] dir : DIRS) {
                int newX = loc[0] + dir[0];
                int newY = loc[1] + dir[1];
                if (newX >= 0 && newX < size && newY >= 0 && newY < size && visited[newX][newY] == 0
                        && grid[newX][newY] == LAND) {
                    q.offer(new int[] { newX, newY });
                    visited[newX][newY] = labelIndex;
                }
            }
        }
        return count;
    }
	
	
	public static void main(String[] args) {
		System.out.println(new MakingALargeIsland827().largestIsland(new int[][] {{1,1},{1,0}}));
	}

}
