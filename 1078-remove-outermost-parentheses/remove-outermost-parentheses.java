class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int depth=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(depth>0)sb.append(ch);
                depth++;
            }
            if(ch==')'){
                depth--;
                if(depth>0)sb.append(ch);
            }
        }
        return sb.toString();
    }
}