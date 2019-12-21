class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        char[] answerArray = new char[0]; // 最终找到的子数组
        int left = 0, right = 0; // 子数组的左右下标
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[] charCountInT = new int[128];
        for (char c : tArray) charCountInT[c]++; // 统计字符串 T 中每个字符的数量
        int zen = t.length(); // t 字符串所有字符在子数组中还缺的总个数
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
