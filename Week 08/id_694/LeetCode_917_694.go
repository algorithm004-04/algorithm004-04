func reverseOnlyLetters(S string) string {
    temp := []byte(S)
    flagI, flagJ :=  false, false
    for i, j := 0, len(temp)-1; i < j;{
        if temp[i]>='A' && temp[i]<='Z' || temp[i]>='a' && temp[i]<='z'{
            flagI = true
        }else{
            flagI = false
            i++
        }
        if temp[j]>='A' && temp[j]<='Z' || temp[j]>='a' && temp[j]<='z'{
            flagJ = true
        }else{
            flagI = false
            j--
        }
        if flagI && flagJ{
            temp[i],temp[j] = temp[j],temp[i]
            i++
            j--
        }
        
    }
    return string(temp)
}
