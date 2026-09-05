class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int limit=1;
        int max=nums[0];
        int min=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
                if(min==0)break;
        }
        }
        if((max-min)<=k)return 0;
        while(limit<nums.length){
            if(nums[limit]>max)max=nums[limit];
            if(nums[nums.length-1]==0)min=0;
            else if(nums[limit-1]==min){
                min=Integer.MAX_VALUE;
                for(int j=limit;j<nums.length;j++){
                    if(nums[j]<min)min=nums[j];
                }
            }
            if((max-min)<=k){
                return limit;
            }
            limit++;
        }
        return ans;
    }
}