class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        Stack<Character> rt=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(st.size()==0)st.push(ch);
            else if(st.peek()==ch)st.pop();
            else st.push(ch);
        }
        String str="";
        while(st.size()>0){
            rt.push(st.pop());
        }
        while(rt.size()>0){
            str+=rt.pop();
        }
        return str;
    }
}