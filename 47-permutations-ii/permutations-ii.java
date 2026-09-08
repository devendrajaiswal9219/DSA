class Solution {
    public void backtrack(int[] nums,List<Integer> list,List<List<Integer>> result,boolean[] visited){
        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0 && visited[i-1]==true){
                if(i>0 && nums[i]==nums[i-1])continue;
            }
            if(!visited[i]){
                visited[i]=true;
                list.add(nums[i]);
                backtrack(nums,list,result,visited);
                list.remove(list.size()-1);
                visited[i]=false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,list,result,visited);
        return result;
    }
}