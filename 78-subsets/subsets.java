class Solution {
    public void subsets(int idx,int[] arr,List<Integer> list,List<List<Integer>> result){
        if(arr.length==idx){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[idx]);
        subsets(idx+1,arr,list,result);
        list.remove(list.size()-1);
        subsets(idx+1,arr,list,result);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        subsets(0,nums,list,result); 
        return result;
    }
}