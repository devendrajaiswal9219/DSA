class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        Queue<Integer> q=new LinkedList<>();
        int[] visited=new int[isConnected.length];
        Arrays.fill(visited,0);
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0){
                count++;
            }
            q.add(i);
            visited[i]=1;
            while(!q.isEmpty()){
                int x=q.poll();
                for(int j=0;j<isConnected[x].length;j++){
                    if(isConnected[x][j]==1 && visited[j]==0){
                        visited[j]=1;
                        q.add(j);
                    }
                }
            }
        }
        return count;
    }
}