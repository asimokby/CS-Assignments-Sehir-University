#include <stdio.h>
#include <math.h>

//check if a given number n is prime or not. 
int is_prime(int n){
    if (n == 0 || n == 1) return 0;  //handle 0 and 1 cases because because loop starts from i = 2. 
    for (int i = 2; i<=sqrt(n); i++)
        if (n % i == 0) return 0; //if not prime
    return 1; //if prime
}

//print the smallest pair of twin primes. 
void is_twin_prime(int n){
    int t = n + 1;
    int last_seen = n-2; //to fail the first check 
    while (1){  
        if (is_prime(t)){
            if ((t - last_seen) == 2){
                
                printf("Twin primes: %d  %d \n", last_seen, t); //two numbers apart "check"
                break; 
                }
            last_seen = t;  //save last seen prime     
        }
        t++;
    }
}

int main(){    
    int n;
    printf("Program1: \n");
    printf("Enter an integer: ");
    scanf("%d", &n); //take input from user.
    is_twin_prime(n); //print the smallest pair of twin primes.
}