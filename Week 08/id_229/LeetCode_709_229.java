public class LeetCode_709_8_转换成小写字母 {
    public String toLowerCase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 65 && c <= 90) {
                c += 32;
            }
            result += c;
        }
        return result;
    }
}
