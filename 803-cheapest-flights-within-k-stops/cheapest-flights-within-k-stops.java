class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:flights){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new int[]{v, w});
        }
        int[][] dist=new int[n][k+2];
        for(int i = 0; i < n; i++){
    Arrays.fill(dist[i], Integer.MAX_VALUE);
}
        dist[src][0]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,src,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int cost=curr[0];
            int city=curr[1];
            int stop=curr[2];
            if(city==dst){
                return cost;
            }
            if(stop>k){
                continue;
            }
            for(int[] edge:adj.get(city)){
                int nextcity=edge[0];
                int price=edge[1];
                int newCost=cost+price;
                if(newCost<dist[nextcity][stop+1]){
                    dist[nextcity][stop+1]=newCost;
                    pq.offer(new int[]{newCost,nextcity,stop+1});
                }
            }
        }
        return -1;
    }
}