class Solution {
    public void dfs(int i,int j,char[][] board,boolean[][] visited){
        visited[i][j]=true;
        int[][] direction={
            {-1,0},
            {1,0},
            {0,1},
            {0,-1}
        };
        for(int[] dir:direction){ 
            int ni=i+dir[0];
            int nj=j+dir[1];
            if(ni>=0 && ni<board.length && nj>=0 && nj<board[0].length && board[ni][nj]=='O' && !visited[ni][nj]){
                dfs(ni,nj,board,visited);
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int j=0;j<n;j++){
            if(!visited[0][j] && board[0][j]=='O'){
                dfs(0,j,board,visited);
            }
            if(!visited[m-1][j] && board[m-1][j]=='O'){
                dfs(m-1,j,board,visited);
            }
        }
        for(int i=0;i<m;i++){
            if(!visited[i][0] && board[i][0]=='O'){
                dfs(i,0,board,visited);
            }
            if(!visited[i][n-1] && board[i][n-1]=='O'){
                dfs(i,n-1,board,visited);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}