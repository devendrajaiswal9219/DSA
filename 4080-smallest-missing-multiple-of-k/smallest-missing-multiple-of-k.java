class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int j=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==(k*j)){
                j++;
            }
        }
        return j*k;
    }
}