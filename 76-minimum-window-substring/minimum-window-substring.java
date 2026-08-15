class Solution {
    public String minWindow(String s, String t) {
     
       //  2  HASHMAP SOLUTION


        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> have = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int count = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            have.put(ch, have.getOrDefault(ch, 0) + 1);

            if (need.containsKey(ch) && have.get(ch) <= need.get(ch)) {
                count++;
            }

            while (count == t.length()) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                have.put(leftChar, have.get(leftChar) - 1);

                if (need.containsKey(leftChar)
                        && have.get(leftChar) < need.get(leftChar)) {
                    count--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}