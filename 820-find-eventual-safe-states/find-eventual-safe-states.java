class Solution {
    public boolean dfs(int[] visited,int[] path,int node,int[][] graph){
        visited[node]=1;
        path[node]=1;
        for(int x:graph[node]){
            if(path[x]==1){
                return true;
            }
            if(visited[x]==0){
                if(dfs(visited,path,x,graph)){
                    return true;
                }
            }
        }
        path[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list=new ArrayList<>();
        int[] visited=new int[graph.length];
        int[] path=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(visited[i]==0){
                dfs(visited,path,i,graph);
            }
        }
        for(int i=0;i<graph.length;i++){
            if(path[i]==0)list.add(i);
        }
        return list;
    }
}