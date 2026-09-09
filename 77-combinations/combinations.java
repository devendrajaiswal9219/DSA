class Solution {
    public void backtrack(int idx,int n,int k,List<Integer> list,List<List<Integer>> result){
        if(list.size()==k){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<n;i++){
            list.add(i+1);
            backtrack(i+1,n,k,list,result);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        backtrack(0,n,k,list,result);
        return result;
    }
}