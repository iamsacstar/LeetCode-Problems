//You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.
//Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

class Solution {
    public int shortestPath(int[][] grid, int k) {
        boolean[][][] isVisited = new boolean[grid.length][grid[0].length][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        int result = 0;
        queue.offer(new int[]{0, 0, k});
        isVisited[0][0][k] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int a = 0; a < size; a++) {
                int[] c = queue.poll();
                int i = c[0];
                int j = c[1];
                int currentK = c[2];
                if(i == grid.length - 1 && j == grid[0].length - 1) return result;
                if(grid[i][j] == 1 && currentK == 0) continue;
                int nextK = currentK;
                if(grid[i][j] == 1) {
                    nextK--;
                }
                if(i - 1 >= 0 && !isVisited[i - 1][j][nextK]) {
                    queue.offer(new int[]{i - 1, j, nextK});
                    isVisited[i - 1][j][nextK] = true;
                }
                if(j - 1 >= 0 && !isVisited[i][j - 1][nextK]) {
                    queue.offer(new int[]{i, j - 1, nextK});
                    isVisited[i][j - 1][nextK] = true;
                }
                if(i + 1 < grid.length && !isVisited[i + 1][j][nextK]) {
                    queue.offer(new int[]{i + 1, j, nextK});
                    isVisited[i + 1][j][nextK] = true;
                }
                if(j + 1 < grid[0].length && !isVisited[i][j + 1][nextK]) {
                    queue.offer(new int[]{i, j + 1, nextK});
                    isVisited[i][j + 1][nextK] = true;
                }
            }
            result++;
        }
        return -1;
    }
}
