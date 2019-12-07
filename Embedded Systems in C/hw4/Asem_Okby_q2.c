#include <stdio.h>

void q2(){
    char input[100];
    printf("Enter a string: ");
    scanf("%s",input);
    printf("INPUT: %s \n",input);
    printf("OUTPUT: ");
    int count = 1; //start with count 1, to count the first letter
    for(int i = 0; input[i] != '*'; i++){ //stop when it reaches the star
        if (input[i] != input[i+1]) //checking if the next char is as the current
        {   
            printf("%d%c", count, input[i]); //print freq of the char and the char
            count = 0; //set count to zero when a new character is introduced
        } 
        count++; //incrementing the count
    }
    printf("\n"); //printing a new line
}

int main(){
    q2();

}