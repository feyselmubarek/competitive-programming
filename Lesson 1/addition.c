#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define new_max(x,y) ((x) >= (y)) ? (x) : (y)

void performAddition(){
    char number1[] = "12345678901987654322112312123141";
    char number2[] = "12345678901987654322112312123141";

    size_t length = strlen(number1);
    size_t length2 = strlen(number2);

    char* upperNumber;
    char* lowerNumber;
    
    if (length > length2)   
    {
        upperNumber = number1;
        lowerNumber = number2;
        char result[size_of(length)];
    
    }else{
        upperNumber = number2;
        lowerNumber = number1;
        char result[size_of(length2)];
    }
    
    int carry = 0;
    int value = 0;

    for (int i = length-1; i > 0; i--)
    {
        int num = (upperNumber[i] - '0') + (lowerNumber[i] - '0');

        if (num > 10)
        {
            carry += num - 9; 
        }
             
    }
    

}

int main()
{   
    performAddition();
    return 0;
}