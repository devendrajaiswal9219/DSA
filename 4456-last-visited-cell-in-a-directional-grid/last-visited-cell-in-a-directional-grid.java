class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        int i = 0;
        int j = 0;
        int prvI=-1;
        int prvJ=-1;
        while (true) {
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return new int[]{prvI, prvJ};
            }
            if (visited[i * n + j]) {
                return new int[]{prvI, prvJ};
            }
            prvI=i;
            prvJ=j;
            visited[i * n + j] = true;
            if (grid[i][j] == 'R') {
                j++;
            }
            else if (grid[i][j] == 'D') {
                i++;
            }
            else if (grid[i][j] == 'U') {
                i--;
            }
            else if (grid[i][j] == 'L') {
                j--;
            }
        }
    }
}