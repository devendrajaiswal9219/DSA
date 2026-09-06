class Solution {
    public void combination(int idx,int sum,int k,int[] arr,List<Integer> list,List<List<Integer>> result){
        if(sum==k){
            result.add(new ArrayList<>(list));
            return;
        }
        if(idx==arr.length || sum>k){
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1])continue;
            list.add(arr[i]);
            sum+=arr[i];
            combination(i+1,sum,k,arr,list,result);
            sum-=arr[i];
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        combination(0,0,target,candidates,list,result);
        return result;
    }
}