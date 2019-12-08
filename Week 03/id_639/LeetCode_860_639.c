/*
	看了10分钟没有思路，看题解看题解看题解，以前都是没有思路，继续想，这条路走不通，需要换一种思路了
	看题解，看好的代码，寻找反馈
*/

bool lemonadeChange(int *bills,int billsSize) {
    int five = 0,ten = 0;
    int i;

    for (i = 0;i < billsSize;i++) {
        if (bills[i] == 5) {
            five++;
        }else if (bills[i] == 10) {
            if (five == 0) {
                return false;
            }
            five--;
            ten++;
        }else {
            if (five > 0 && ten >0) {
                five--;
                ten--;
            }else if (five >= 3) {
                five -= 3;
            }else {
                return false;
            }
        }
    }
    return true;
}