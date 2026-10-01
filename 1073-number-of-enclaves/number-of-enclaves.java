class Solution {
    public int dfs(int[][] grid,int i,int j,int count){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return -1000;
        }
        if(grid[i][j]==0)return 0;
        grid[i][j]=0;
        count++;
        int p=dfs(grid,i-1,j,0);
        int q=dfs(grid,i+1,j,0);
        int r=dfs(grid,i,j-1,0);
        int s=dfs(grid,i,j+1,0);
        if(p < 0 || q < 0 || r < 0 || s < 0) {
            return -1000;
        }
        return count+p+q+r+s;
    }
    public int numEnclaves(int[][] grid) {
        int count=0;
        int x=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    x=dfs(grid,i,j,0);
                if(x>0)count+=x;
        }
            }
        }
        return count;
    }
}