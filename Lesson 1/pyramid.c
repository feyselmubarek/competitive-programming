#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int main(){
    int n;

    printf("Enter the number of rows: ");
    scanf("%d", &n);

    for (int row = n; row > 0; row--)
    {
        // space printer
        for (int spaceColumn = 1; spaceColumn < row; spaceColumn++)
        {
            printf(" ");
        }
        
        // star printer
        for (int starColumn = 1; starColumn <= ((2*((n+1) - row)) -1); starColumn++)
        {
            printf("*");
        }
        printf("\n");
    }    

    return 0;
}