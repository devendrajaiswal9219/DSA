class Solution {
    public boolean dfs(int[] color,int[][] graph,int col,int i){
        color[i]=col;
        for(int x:graph[i]){
            if(color[x]==-1){
                if(dfs(color,graph,1-col,x)==false)return false;
            }
            else if(color[x]==col)return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            color[i]=-1;
        }
        for(int i=0;i<color.length;i++){
            if(color[i]==-1){
                if(dfs(color,graph,1,i)==false)return false;
            }
        }
        return true;
    }
}