class Solution {

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Put all rotten oranges into queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] direction = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int count = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // Process one complete level
            for (int k = 0; k < size; k++) {

                int[] x = q.poll();

                int i = x[0];
                int j = x[1];

                for (int[] dir : direction) {

                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    if (ni < 0 || ni >= m ||
                        nj < 0 || nj >= n ||
                        grid[ni][nj] != 1) {
                        continue;
                    }

                    // Fresh orange becomes rotten
                    grid[ni][nj] = 2;

                    q.add(new int[]{ni, nj});
                }
            }

            // One minute completed
            if (!q.isEmpty()) {
                count++;
            }
        }

        // Check if any fresh orange remains
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return count;
    }
}