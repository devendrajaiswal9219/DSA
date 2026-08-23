class Solution {
    public boolean sumGame(String num) {
        char[] ch = num.toCharArray();
        int lsum = 0, rsum = 0;
        int lq = 0, rq = 0;
        for(int i = 0; i < ch.length / 2; i++) {
            if(ch[i] == '?') {
                lq++;
            } else {
                lsum += ch[i] - '0';
            }
            int j=ch.length-i-1;
            if(ch[j]=='?') {
                rq++;
            } else {
                rsum += ch[j]-'0';
            }
        }
        if(lsum==rsum && lq==rq)return false;
        if((rq-lq)%2!=0)return true;
        return (lsum-rsum)!=9*(rq-lq)/2;
    }
}