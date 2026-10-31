class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0,high=0;
        for(int ele:nums){
            low=Math.max(ele,low);
            high+=ele;
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int parts=1;
            int sum=0;
            for(int ele:nums){
                if(sum+ele>mid){
                    parts++;
                    sum=ele;
                }
                else{
                    sum+=ele;
                }
            }
            if(parts<=k){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}