class Solution {
    public void combination(int idx,int sum,int k,int n,List<Integer> list,List<List<Integer>> result){
        if(list.size()==k){
            if(sum==n){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if(idx>(n-k) || sum>n)return;
        for(int i=idx;i<=(n-k+1) && i<=8;i++){
            list.add(i+1);
            sum+=(i+1);
            combination(i+1,sum,k,n,list,result);
            list.remove(list.size()-1);
            sum-=(i+1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        combination(0,0,k,n,list,result);
        return result;
    }
}