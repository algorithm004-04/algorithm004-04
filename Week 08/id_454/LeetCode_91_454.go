func numDecodings(s string) int {
    count:=1
    prvCount:=1 // for an empty string
    for i:=0; i<len(s);i++{
        newCount:=0
        if i>0 && (s[i-1]=='1' || (s[i-1]=='2' && s[i]<'7')){
            newCount += prvCount
        }
        
        if s[i]> '0'{
            newCount += count
        }
        
        prvCount = count
        count = newCount
    }
    
    return count
}