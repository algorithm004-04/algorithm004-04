package week_08.lesson20;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {

        int end = s.length() - 1;
        //去结尾的空格
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int last = end;
        while (end >= 0 && s.charAt(end) != ' ') {
            end--;
        }
        return last - end;
    }

}
