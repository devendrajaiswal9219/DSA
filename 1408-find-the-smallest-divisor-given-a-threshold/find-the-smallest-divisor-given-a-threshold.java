class Solution {
    public boolean possible(int nums[],int mid,int threshold){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%mid!=0){
                sum+=(nums[i]/mid)+1;
            }
            else sum+=nums[i]/mid;
        }
        if(sum<=threshold)return true;
        return false;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        int ans=0;
        for(int num:nums){
            if(num>high){
                high=num;
            }
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(nums,mid,threshold)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}