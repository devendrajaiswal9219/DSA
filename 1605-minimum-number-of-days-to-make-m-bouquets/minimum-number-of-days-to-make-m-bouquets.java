class Solution {
    public boolean possible(int arr[],int day,int m,int k){
        int count=0;
        int x=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                count++;
            }
            else{
                x+=(count/k);
                count=0;
            }
        }
        x+=(count/k);
        return x>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length)return -1;
        int high=Integer.MIN_VALUE;
        int low=Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]>high){
                high=bloomDay[i];
            }
            if(bloomDay[i]<low){
                low=bloomDay[i];
            }
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(bloomDay,mid,m,k)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}