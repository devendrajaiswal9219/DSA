class Solution {
    public int count(int n){
        if(n==0)return 0;
        if(n%2==0)return 1+count(n/2);
        return 1+count(n-1);
    }
    public int numberOfSteps(int num) {
        return count(num);
    }
}