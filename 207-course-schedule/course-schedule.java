class Solution {
    public boolean dfs(int[] visited,int[] path,ArrayList<ArrayList<Integer>> adj,int node){
        visited[node]=1;
        path[node]=1;
        for(int x:adj.get(node)){
            if(visited[x]==0){
                if(dfs(visited,path,adj,x)==false)return false;
            }
            else if(path[x]==1)return false;
        }
        path[node]=0;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] visited=new int[numCourses];
        int[] path=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] ele:prerequisites){
            int u=ele[0];
            int v=ele[1];
            adj.get(v).add(u);
        }
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(dfs(visited,path,adj,i)==false)return false; 
            }
        }
        return true;
    }
}