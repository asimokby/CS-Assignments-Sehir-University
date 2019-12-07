#include <stdio.h>
#include <math.h>


//building the array of prime numbers between 2-100
int buildArray(int i, int prime_numbers[]){
    int j;
    for (j = 0; prime_numbers[j] != 0; j++){
            if (i % prime_numbers[j] == 0) return 0;  
    }
    return j;
}

//check if a nubmer exists in the prime_numbers list. if not return 0 else return 1 
int is_prime(int n, int prime_numbers[]){
    for (int j = 0; j < 25; j++){
        if (prime_numbers[j] == n) return 1;
    }
    return 0;
}

//print all tiwn primes less than in 
void is_twin_prime(int n, int prime_numbers[]){
    for (int j = 25; j > 0; j--){
        if (prime_numbers[j] >= n) continue;
        if (prime_numbers[j] - prime_numbers[j-1] == 2) printf("%d-%d\n",prime_numbers[j], prime_numbers[j-1]);
    }
}

int main(){    
    //building the array of prime numbers between 2-100
    int prime_numbers[25] = {2};
    for (int i= 3; i < 100; i+=2){ //i+=2 to skip the even numbers, since all evens are not prime (except 2)
        if (buildArray(i, prime_numbers) != 0) 
            prime_numbers[buildArray(i, prime_numbers)] = i;
    }
    int n;
    printf("Please enter a number:");
    scanf("%d", &n);
    while (n < 2 || n > 99) {
        printf("You have entered a number that is not valid. Please enter a number between 2 and 100.\n");
        printf("Please enter a number:");
        scanf("%d", &n);
    }
    if (is_prime(n, prime_numbers)) printf("%d is a prime number\n", n);
    else printf("%d is not a prime number\n", n);

    if (n >= 6){
        printf("All twin prime numbers less than %d are:\n", n);
        is_twin_prime(n, prime_numbers);
    }else printf("No twin prime numbers less than %d exist.\n", n);


    }

