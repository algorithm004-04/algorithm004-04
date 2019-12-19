public class LeetCode_58_8_最后一个单词的长度 {

    /*
        返回最后一个单词的长度，不存在返回0

        需要注意的情况是末尾带有空格但包含最后一个单词的情况
            尾部遍历法




     */

    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end --;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public int lengthOfLastWord2(String s) {
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                if(count == 0) continue;
                break;
            }
            count++;
        }
        return count;
    }
}
