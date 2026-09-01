class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        int left=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int right=0;right<s.length;right++){
            if(left==g.length)return count;
            if(s[right]>=g[left]){
                count++;
                left++;
            }
        }
        return count;
    }
}