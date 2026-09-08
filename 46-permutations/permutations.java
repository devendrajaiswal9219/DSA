class Solution {
    public void backtrack(int[] nums,List<Integer> list,List<List<Integer>> ans,boolean[] visited){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                list.add(nums[i]);
                backtrack(nums,list,ans,visited);
                list.remove(list.size()-1);
                visited[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        backtrack(nums,list,ans,visited);
        return ans;
    }
}