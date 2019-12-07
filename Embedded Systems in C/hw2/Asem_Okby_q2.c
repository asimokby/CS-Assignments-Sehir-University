#include <stdio.h>

int is_perfect(int n){
    if (n % 2 == 1) return 0; // there is no known odd perfect numbers
    int sum = 0;
    for(int i = 1; i < n; i++){
        if (n % i == 0) sum += i;
    }
    return sum == n; // check if sum of all divisiors is equal to the n 
}


void all_perfect_numbers(int x, int y){
    int perfect_exists = 1;
    for (int i = x+1; i < y; i++) //loop from x+1 until y -1   
        if (is_perfect(i)){ // if number is perfect, print it.
            if (perfect_exists){
                printf("Perfect numbers:");
                perfect_exists = 0;}
            printf(" %d", i);}
    if (perfect_exists) printf("No such perfect number");
    printf("\n");
}


int main(){    
    int a, b;
    printf("Program2: \n");
    printf("Enter the first number: ");
    scanf("%d", &a);
    printf("Enter the second number: ");
    scanf("%d", &b);
    all_perfect_numbers(a, b);
}

