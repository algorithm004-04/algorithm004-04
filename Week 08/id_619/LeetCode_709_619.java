class Solution {
    public String toLowerCase(String str) {
        char[] st = new char[str.length()];
        for (int i=0; i<str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp >= 65 && tmp <= 90) {
                tmp = (char)(tmp+32);
            }
            st[i] = tmp;
        }
        return new String(st);
    }
}