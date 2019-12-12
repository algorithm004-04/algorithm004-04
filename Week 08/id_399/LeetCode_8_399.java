class Solution {
    public int myAtoi(String str) {
        StringBuffer res=new StringBuffer();
        for (char c : str.toCharArray()) {
            if (c==' '&&res.toString().equals(""))
                continue;
            if (res.length()==0&&(c=='-'||c=='+'))
            {
             res.append(c);
                                continue;
            }
            if ((c<='9'&&c>='0'))
                res.append(c);
            else
                break;
        }
        int r;
        try {
            r = Integer.valueOf(res.toString());
        } catch (NumberFormatException e) {
            if (res.length()==0||res.length()==1)
                return 0;
            r=res.charAt(0)=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        return r;
    }
}
