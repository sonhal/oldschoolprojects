/* 
 * File:   newmain.c
 * Author: sonhal
 *
 * Created on 5. februar 2017, 02:23
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main() {
    int ca = 1;
    int c = 6;
    int a;
    //asks for inout
    printf("print 6 nr: \n"); fflush(stdout);
    
    //starts a loop to get input
    while(c > 0){
        
        int d;
        //tells the user what number its on
        printf("nr: %d \n", ca); fflush(stdout);
        //takes input
        scanf("%d", &d);
        //checks if the input is larger then previous input
        if(a < d){
            //changes the biggest input counter
            a = d;
        }
        c--;
        ca++;
}
    //prints the biggest input
printf("biggest nr: %d", a);
return 0;
}

    
