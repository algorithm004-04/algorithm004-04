int myAtoi(char * str){
    // 移除开头的空格
    while (*str == ' ') {
        ++str;
    }
    
    // 记录正负性
    int flag = 1;
    if (*str == '-') {
        flag = -1;
        ++str;
    }else if (*str == '+') {
        ++str;
    }
    
    int ret = 0;
    int div = INT_MAX / 10;
    
    while (*str <= '9' && *str >= '0') {
        int dig = *str - '0';
        
        if (ret < div || (ret == div && dig < 8)) {
            ret = ret * 10 + dig;
            ++str;
        }else {
            return flag == 1 ? INT_MAX : INT_MIN;
        }
    }
    return flag * ret;
}


