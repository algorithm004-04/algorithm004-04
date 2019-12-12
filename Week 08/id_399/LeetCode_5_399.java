class Solution {
    public String theMaxHuiWenStringIni(String s,String max,int last,int next,int i){
        int length=s.length();
        while(true){
            if(i-last<0||i+next>=length)break;
            if(s.charAt(i-last)!=s.charAt(i+next))break;
            last++;
            next++;
        }
        if(next+last-1>max.length())max=s.substring(i-last+1,i+next);
        return max;
    }
    public String longestPalindrome(String s) {
        int length=s.length();
        if(length==1)return s;
        String max="";
        for(int i=0;i<length-1;i++){
            max=theMaxHuiWenStringIni(s,max,1,1,i);
            if(s.charAt(i)==s.charAt(i+1)){
                max=theMaxHuiWenStringIni(s,max,1,2,i);
            }
        }
        return max;
    }
}
