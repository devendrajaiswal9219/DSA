class Solution {

    public long result(String s, int i, long ans, int sign) {

        // End of string
        if (i == s.length()) {
            return sign * ans;
        }

        char ch = s.charAt(i);

        // Take digit
        if (ch >= '0' && ch <= '9') {

            ans = ans * 10 + (ch - '0');

            // Overflow
            if (ans > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            return result(s, i + 1, ans, sign);
        }

        // Stop at first non-digit
        return sign * ans;
    }

    public int myAtoi(String s) {

        int i = 0;

        // Skip spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i == s.length()) {
            return 0;
        }

        // Sign
        int sign = 1;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } 
        else if (s.charAt(i) == '+') {
            i++;
        }

        return (int) result(s, i, 0, sign);
    }
}