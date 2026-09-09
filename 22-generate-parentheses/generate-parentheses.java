class Solution {
    public void backtrack(String str,int open,int close,int n,List<String> result){
        if(str.length()==2*n){
            result.add(str);
            return;
        }
        if(close>open)return;
        if(open<n){
            backtrack(str+'(',open+1,close,n,result);
        }
        if(close<n){
            backtrack(str+')',open,close+1,n,result);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        backtrack("",0,0,n,result);
        return result;
    }
}