func numDistinct(s string, t string) int {
    if len(s)<len(t){
        return 0
    }
    CONCLUDE:=make([][]int,len(s)+1)
    for i:=0;i<len(s)+1;i++{
        CONCLUDE[i]=make([]int,len(t)+1)
    }
    for i:=0;i<len(s)+1;i++{
        CONCLUDE[i][0]=1
    }
    for i:=1;i<len(s)+1;i++{
        for j:=1;j<len(t)+1;j++{
            if s[i-1]!=t[j-1]{
                CONCLUDE[i][j]=CONCLUDE[i-1][j]
            }else if s[i-1]==t[j-1]{
                CONCLUDE[i][j]=CONCLUDE[i-1][j]+CONCLUDE[i-1][j-1]
            }
        }
    }
    return CONCLUDE[len(s)][len(t)]
}