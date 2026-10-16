class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->x[0]-y[0]);
        dist[0][0]=0;
        pq.offer(new int[]{0,0,0});
        int[][] dir={
            {0,1},{0,-1},{1,0},{-1,0}
        };
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int x=curr[0];
            int r=curr[1];
            int c=curr[2];
            if(r==m-1 && c==n-1){
                return x;
            }
            if(x>dist[r][c]){
                continue;
            }
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr<0 || nr>=m || nc<0 ||nc>=n){
                    continue;
                }

                int diff=Math.abs(heights[r][c]-heights[nr][nc]);
                int newx=Math.max(x,diff);
                if(newx<dist[nr][nc]){
                    dist[nr][nc]=newx;

                    pq.offer(new int[]{newx,nr,nc});
                }
            }
        }
        return 0;
    }
}