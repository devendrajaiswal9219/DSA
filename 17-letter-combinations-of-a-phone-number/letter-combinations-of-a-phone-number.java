class Solution {
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public void backtrack(int idx,List<String> list,String str,String digits){
        if(idx==digits.length()){
            list.add(str);
            return;
        }
        String s = map[digits.charAt(idx) - '0'];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            backtrack(idx+1,list,str+ch,digits);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        backtrack(0,list,"",digits);
        return list;
    }
}