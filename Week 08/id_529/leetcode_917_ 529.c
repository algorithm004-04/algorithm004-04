#include <stdio.h>
#include <string.h>
void swapChar(char *a, char* b)
{
    char temp;
    temp = *a;
    *a = *b;
    *b = temp;
}
char * reverseOnlyLetters(char * s){
    int len = strlen(s);
    int j = len-1;
    int i = 0;
    while (i < j) {
        if ((s[i]>='a' && s[i] <='z') || (s[i]>='A' && s[i] <='Z')) {
            if ((s[j] >= 'a' && s[j] <='z') || (s[j]>='A' && s[j] <='Z')) {
                swapChar(&s[i],&s[j]);
                i++;
                j--;
            } else {
                j-- ;
            }
        } else {
            i++;
        }
    }
}
int main()
{
    char s[100] = "Test1ng-Leet=code-Q!";
    printf("%s\n", s);
    reverseOnlyLetters(s);
    printf("%s", s);
}