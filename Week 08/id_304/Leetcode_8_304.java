class Solution {
public int myAtoi(String str) {

    str = str.trim();
    if(str == null)return 0;
    if(str.length()==0)return 0;
    long lng =0;
    int s =1;
    int f = 0;
    if(str.charAt(0)=='-'){s=-1;f=1;}
    if(str.charAt(0)=='+'){s=1;f=1;}
    for(int i=f;i<str.length();i++){
        int t = str.charAt(i)-48;
        if((t>=0)&&(t<10)){
            lng+=t;
            lng*=10;
            if(lng >(long)Integer.MAX_VALUE*10)break;
        }
        else break;
    }
    lng/=10;
    lng*=s;
    if(lng>Integer.MAX_VALUE)return Integer.MAX_VALUE;
    if(lng<=Integer.MIN_VALUE)return Integer.MIN_VALUE;
    return (int)(lng);
 }
}
