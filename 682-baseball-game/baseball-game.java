class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> list=new ArrayList<>();
        int j=0;
        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("D")){
                list.add(j,2*list.get(j-1));
                j++;
            }
            else if(operations[i].equals("C")){
                list.remove(j-1);
                j--;
            }
            else if(operations[i].equals("+")){
                list.add(j,list.get(j-1)+list.get(j-2));
                j++;
            }
            else{
                list.add(j,Integer.parseInt(operations[i]));
                j++;
            }
        }
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        return sum;
    }
}