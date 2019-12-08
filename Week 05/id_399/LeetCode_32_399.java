class Solution {
    public int longestValidParentheses(String s) {
        char[] sc = s.toCharArray();
        int res = 0;
        int left = 0;
        int right = 0;
        int i = 0;
        for (; i < sc.length; i++) {
            if (sc[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                if (res < left) {
                    res = left;
                }
            } else if (left < right) {
                int temp = rightToLeft(i - left - right, i - 1, sc);
                if (res < temp)
                    res = temp;
                left = 0;
                right = 0;
            } else {
                continue;
            }
        }
        if (res < right) {
            int temp = rightToLeft(i - left - right, i - 1, sc);
            if (res < temp)
                res = temp;
        }
        return res * 2;
    }

    public int rightToLeft(int start, int end, char[] sc) {
        int res = 0;
        int left = 0;
        int right = 0;
        if (start < 0 || end < 0) {
            return 0;
        }
        for (int i = end; i >= start; i--) {
            if (left == right) {
                if (res < left) {
                    res = left;
                }
                if (sc[i] == ')') {
                    right++;
                } else {
                    left = 0;
                    right = 0;
                }
            } else {
                if (sc[i] == ')') {
                    right++;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}