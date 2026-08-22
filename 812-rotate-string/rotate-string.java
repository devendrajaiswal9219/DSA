class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())return false;
        int i=0;
        int count=0;
        for(int j=0;j<(2*goal.length());j++){
            int x=j%(goal.length());
            if(goal.charAt(x)==s.charAt(i)){
                count++;
                if(count==s.length() || i==(s.length()-1))break;
                i++;
            }
            else{
                while(count>0){
                    count--;
                    j--;
                }
                count=0;
                i=0;
            }
        }
        if(count==s.length())return true;
        return false;
    }
}