class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        char[] answerArray = new char[0]; // 最终找到的子数组
        int left = 0, right = 0; 
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[] charCountInT = new int[128];
        for (char c : tArray) charCountInT[c]++; 
        int zen = t.length(); 
        while (right < s.length()) {
            charCountInT[sArray[right]]--;
            if (charCountInT[sArray[right]] >= 0) zen--;
            if (zen == 0) {
                while (charCountInT[sArray[left]] < 0) {
                    charCountInT[sArray[left++]]++;
                }
                if (right - left + 1 < answerArray.length || answerArray.length == 0) {
                    answerArray = Arrays.copyOfRange(sArray, left, right + 1);
                }
                charCountInT[sArray[left++]]++;
                zen++;
            }
            right++;
        }
        return new String(answerArray);
    }
}
