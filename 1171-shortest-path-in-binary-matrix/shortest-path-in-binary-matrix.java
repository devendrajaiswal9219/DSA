class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
        int[][] dir={ 
            {-1,-1},{-1,0},{-1,1},
            {0,-1},{0,1},
            {1,-1},{1,0},{1,1}
        };
        int[][] dist=new int[n][n];
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0});
        dist[0][0]=1;
        while(!q.isEmpty()){
            int[] x=q.poll();
            int r=x[0];
            int c=x[1];
            if(r==n-1 && c==n-1){
                return dist[r][c];
            }
            for(int[] y:dir){
                int nr=r+y[0];
                int nc=c+y[1];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0 && dist[nr][nc]==0){
                    dist[nr][nc]=dist[r][c]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return -1;
    }
}