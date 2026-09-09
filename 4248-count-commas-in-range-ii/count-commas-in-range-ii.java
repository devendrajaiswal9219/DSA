class Solution {
    public long countCommas(long n) {
        long count=0;
        long i=1000;
        //if(n<1000)return count;
        while(i<=n){
            count+=(n-i+1);
            if(i>Long.MAX_VALUE/1000){break;}
            i*=1000;
        }
        return count;
    }
}