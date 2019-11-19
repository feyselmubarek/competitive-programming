#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int main(){
    // question 3
    int n;
    
    printf("Enter no of rows %d", n);
    scanf("%d", &n);
    
    int counter = 0;

    for (int row = 1; row <= n; row++)
    {
        for (int column = 1; column <= row; column++)
        {
            printf("*");
        }
        printf("\n");
        
    }
    
    return 0;
}