class Solution {
    public int convert(String str,int[] days){
        int month=Integer.parseInt(str.substring(0,2));
        int date=Integer.parseInt(str.substring(3,5));
        int total=0;
        for(int i=1;i<month;i++){
            total+=days[i];
        }
        int ans=total+date;
        return ans;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days={0,31,28,31,30,31,30,31,31,30,31,30,31};
        int AliceArrivalDate=convert(arriveAlice,days);
        int BobArrivalDate=convert(arriveBob,days);
        int AliceDepartureDate=convert(leaveAlice,days);
        int BobDepartureDate=convert(leaveBob,days);
        int low=Math.max(AliceArrivalDate,BobArrivalDate);
        int high=Math.min(AliceDepartureDate,BobDepartureDate);
        return Math.max(0,high-low+1);
    }
}