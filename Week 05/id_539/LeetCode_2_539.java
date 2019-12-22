class Solution {
    public int longestValidParentheses(String s) {
        char[] S = s.toCharArray();
        int[] V = new int[S.length];
        int open = 0;
        int max = 0;
        for (int i = 0; i < S.length; i++) {
            if (S[i] == '(') {
                open++;
            } else if (S[i] == ')' && open > 0) {
                V[i] = 2 + V[i - 1] + (i - 2 - V[i - 1] > 0 ? V[i - 2 - V[i - 1]] : 0);
                open--;
            }

            if (V[i]>max){
                max = V[i];
            }
        }

        return max;
    }
}