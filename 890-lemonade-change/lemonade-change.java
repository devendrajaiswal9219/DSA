class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0]!=5)return false;
        int count5=1;
        int count10=0;
        for(int i=1;i<bills.length;i++){
            if(bills[i]==5)count5++;
            else if(bills[i]==10){
                if(count5>=1){
                    count5--;
                    count10++;
                }
                else return false;
            }
            else if(bills[i]==20){
                if(count5>=1 && count10>=1){
                    count5--;
                    count10--;
                }
                else if(count5>=3){
                    count5-=3;
                }
                else return false;
            }
        }
        return true;
    }
}