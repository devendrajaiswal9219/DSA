class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }
        int[][] directions={
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
        };
        int count=0;
        while(!q.isEmpty()){
            int[] x=q.poll();
            int i=x[0];
            int j=x[1];
            for(int[] dir:directions){
                int ni=i+dir[0];
                int nj=j+dir[1];
                if(ni<0 || ni>=m ||
                    nj<0 || nj>=n ||mat[ni][nj]!=-1){
                        continue;
                    }
                mat[ni][nj]=mat[i][j]+1;
                q.add(new int[]{ni,nj});
            }
        }
        return mat;
    }
}