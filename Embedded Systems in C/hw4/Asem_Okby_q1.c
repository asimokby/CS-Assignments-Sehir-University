#include <stdio.h>


void sort (int myArray[], int size);


int main(){
    int const size = 101;
    int freq[size] = {0}; //initializing an array to hold the frequencies
    sort(freq, size);
}

void sort(int freq[], int size ){
    char input[100]; //taking input from user
    int x, i, j, k; 
    printf("Enter integers: ");
    scanf ("%[^\n]%*c", input);
    for (i = 0; input[i] != '\0'; i++){
        x = (input[i] - '0'); // convert char to int
        if (x > -1){   //avoiding the spaces (they are negative after subtracting from 0)
            freq[x] += 1; //incrementing the index
        }
    }
    for (j= 0; j < 101; j++ ){ // iterate through the array and print that many number of the index value
        for(k = 0; k < freq[j]; k++) 
            printf("%d ", j);
    }
    printf("\n");
}



