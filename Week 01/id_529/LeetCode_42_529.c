#include <stdlib.h>
#include <stdio.h>
#define MYMIN(a, b) ((a) < (b) ? (a) : (b))
int trap(int* height, int heightSize)
{
    int *myStack = (int*)malloc(sizeof(int)*(heightSize+1));
    int topIdx = 0;
    int i = 0;
    int width;
    int high;
    int sum = 0;
    myStack[0] = 0;
    for (i = 0; i < heightSize; i++) {
        while (topIdx != 0 && height[i] > height[myStack[topIdx]]) {
            high = height[myStack[topIdx]];
            topIdx--;
            high = MYMIN(height[i], height[myStack[topIdx]]) - high;
            if (topIdx == 0) {
                break;
            }
            width = i - myStack[topIdx] - 1;
            sum += high * width;
        }
        myStack[++topIdx] = i;
    }
    free(myStack);
    return sum;
}

