class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int a[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    a[i] = (i >= 2 ? a[i - 2] : 0) + 2;
                } else if (i - a[i - 1] > 0 && s.charAt(i - a[i - 1] - 1) == '(') {
                    a[i] = a[i - 1] + ((i - a[i - 1]) >= 2 ? a[i - a[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, a[i]);
            }
        }
        return max;
    }
}