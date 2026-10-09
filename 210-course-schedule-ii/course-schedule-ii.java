class Solution {
    public boolean dfs(int[] visited,int[] path,ArrayList<ArrayList<Integer>> adj,int node,Stack<Integer> st){
        visited[node]=1;
        path[node]=1;
        for(int x:adj.get(node)){
            if(visited[x]==0){
                if(dfs(visited,path,adj,x,st)==false)return false;
            }
            else if(path[x]==1)return false;
        }
        st.push(node);
        path[node]=0;
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] visited=new int[numCourses];
        int[] path=new int[numCourses];
        Stack<Integer> st=new Stack<>();
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
                if(dfs(visited,path,adj,i,st)==false)return new int[0]; 
            }
        }
        int[] ans=new int[numCourses];
        int i=0;
        while(!st.isEmpty()){
            int x=st.peek();
            ans[i]=x;
            i++;
            st.pop();
        }
        return ans;
    }
}