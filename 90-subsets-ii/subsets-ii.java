class Solution {
    public void subsets(int idx,int[] arr,List<Integer> list,List<List<Integer>> result){
        result.add(new ArrayList<>(list));
        for(int i=idx;i<arr.length;i++){
        if(i>idx && arr[i]==arr[i-1])continue;
        list.add(arr[i]);
        subsets(i+1,arr,list,result);
        list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        subsets(0,nums,list,result); 
        return result;
    }
}